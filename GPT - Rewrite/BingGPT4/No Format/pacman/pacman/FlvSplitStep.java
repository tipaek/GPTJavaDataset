package com.yeshj.pacman.schedule.step;

import com.yeshj.pacman.schedule.Constants;
import com.yeshj.pacman.schedule.ExecuteContext;
import com.yeshj.pacman.schedule.StepBase;
import com.yeshj.pacman.schedule.StepExecuteException;
import com.yeshj.pacman.utils.ExternalTool;
import com.yeshj.pacman.utils.FileHelper;
import com.yeshj.pacman.utils.ProcessExecutor;
import org.apache.commons.lang3.StringUtils;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class FlvSplitStep extends StepBase {

    private static final String PREFIX = "[FlvSplitStep]";

    @Override
    public Object execute(ExecuteContext context) throws Exception {
        String mediaFile = context.getAttribute(Constants.CONTEXT_MEDIA_FULLPATH);

        if (!FileHelper.exists(mediaFile)) {
            throw new FileNotFoundException(mediaFile);
        }

        String command = ExternalTool.buildFlvSlicerCommand(mediaFile);

        logger.info("===>CMD:" + command);
        List<String> output = new ArrayList<>();
        ProcessExecutor pe = new ProcessExecutor();
        if (pe.execute(output, command)) {
            logger.warn(PREFIX + " successfully!");
        } else {
            logger.error(PREFIX + " ERROR!\n");
            String buffer = StringUtils.join(output, '\n');
            logger.error(buffer);
            throw new StepExecuteException();
        }

        return null;
    }

    @Override
    public String name() {
        return "flv.split.step";
    }
}
