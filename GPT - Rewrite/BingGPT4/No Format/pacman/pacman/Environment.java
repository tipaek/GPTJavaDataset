package com.yeshj.pacman.startup;

import com.yeshj.pacman.config.AppConfig;
import com.yeshj.pacman.log.ILog;
import com.yeshj.pacman.log.LogFactory;
import com.yeshj.pacman.utils.FileHelper;
import com.yeshj.pacman.utils.ProcessExecutor;
import com.yeshj.pacman.utils.StringHelper;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public final class Environment {

    private static final ILog logger = LogFactory.getLog(Environment.class);
    private static final String PREFIX = "[Environment prechecking]";
    private static final Map<String, Field> gFields = getFileds(AppConfig.class);

    public static boolean precheck() {
        boolean result = false;

        logger.info(PREFIX + " ... start");
        try {
            result = ensureConfigDir("tempDir");
            result = ensureConfigDir("resTempDir");
            result = ensureConfigDir("packTargetDir");
            result = ensureConfigDir("sliceTargetDir");
            result = ensureConfigDir("resTargetDir");

            result = ensureToolExists(AppConfig.getInstance().getExtool_ffmpeg(), true);
            result = ensureToolExists(AppConfig.getInstance().getExtool_python() + " -h", false);
        } catch (Exception e) {
            logger.error(PREFIX + " ... Fail!", e);
        }

        logger.info(PREFIX + " ... done.[" + result + "]");
        return result;
    }

    private static boolean ensureToolExists(String cmd, boolean ignoreResult) {
        boolean result;

        ProcessExecutor pe = new ProcessExecutor();
        try {
            logger.info(PREFIX + " CMD:" + cmd);
            result = pe.execute(null, cmd);
            if (ignoreResult)
                result = true;
            logger.info(PREFIX + " RESULT:" + result);
        } catch (Exception e) {
            logger.error(PREFIX + " Checking Fail!", e);
            result = false;
        }

        return result;
    }

    private static boolean ensureConfigDir(String key) throws IllegalArgumentException, IllegalAccessException {
        if (StringHelper.isEmpty(key)) {
            return true;
        }

        AppConfig config = AppConfig.getInstance();

        if (config == null) {
            logger.error("[Environment prechecking] ERROR: AppConfig is null!");
            return false;
        }

        Field field = gFields.get(key);

        if (field != null) {
            field.setAccessible(true);
            String str = (String) field.get(config);
            FileHelper.ensureExists(str, false);
        } else {
            logger.error("[Environment prechecking] ERROR: AppConfig doesn't contain [" + key + "]");
            return false;
        }

        logger.info("[Environment prechecking] OK: " + key);
        return true;
    }

    private static Map<String, Field> getFileds(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        Map<String, Field> map = new HashMap<>();

        for (Field field : fields) {
            map.put(field.getName(), field);
        }

        return map;
    }
}
