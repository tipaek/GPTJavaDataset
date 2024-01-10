package com.yeshj.pacman.controller;

import com.yeshj.pacman.config.AppConfig;
import com.yeshj.pacman.log.ILog;
import com.yeshj.pacman.log.LogFactory;
import com.yeshj.pacman.utils.FileHelper;
import com.yeshj.pacman.utils.NumericHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FileController extends BaseController {

    private static final ILog logger = LogFactory.getLog(FileController.class);

    private final String resDir = AppConfig.getInstance().getWebResDir();
    private final String audioDir = AppConfig.getInstance().getWebAudioDir();
    private final String videoDir = AppConfig.getInstance().getWebVideoDir();

    public FileController() {
        FileHelper.ensureExists(resDir, false);
        FileHelper.ensureExists(audioDir, false);
        FileHelper.ensureExists(videoDir, false);
    }

    @RequestMapping(value = "/file/upload.go", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public JsonResult uploadFile(@RequestParam("file") MultipartFile image, HttpServletRequest request) {
        JsonResult result = new JsonResult();
        String libId = request.getParameter("lid"); // library id.
        String cwId = request.getParameter("cid"); // courseware id.
        saveFile(image, result, resDir, libId, cwId, false);
        return result;
    }

    @RequestMapping(value = "/audio/upload.go", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public JsonResult uploadAudio(@RequestParam("file") MultipartFile audio, HttpServletRequest request) {
        JsonResult result = new JsonResult();
        String libId = request.getParameter("lid"); // library id.
        String cwId = request.getParameter("cid"); // courseware id.
        saveFile(audio, result, audioDir, libId, cwId, false);
        return result;
    }

    @RequestMapping(value = "/video/upload.go", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public JsonResult uploadVideo(@RequestParam("file") MultipartFile video, HttpServletRequest request) {
        JsonResult result = new JsonResult();
        String libId = request.getParameter("lid"); // library id.
        String cwId = request.getParameter("cid"); // courseware id.
        saveFile(video, result, videoDir, libId, cwId, false);
        return result;
    }

    private void saveFile(MultipartFile file, JsonResult result, String preDir, String libId, String cwId, boolean isPrimary) {
        if (!NumericHelper.isNumeric(libId)) {
            result.setSuccess(0);
            result.setMsg("Invalid parameter: lid!");
            return;
        }

        if (!NumericHelper.isNumeric(cwId)) {
            result.setSuccess(0);
            result.setMsg("Invalid parameter: cid");
            return;
        }

        String imgDir = String.format("%s/%s/%s/", preDir, libId, cwId);
        // The rest of the code goes here...
    }
}
