package com.lmonkey.servlet.user;


import com.lmonkey.util.CodeUtil;
/*import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;*/

import java.awt.image.RenderedImage;
import java.io.IOException;
/*import java.io.OutputStream;*/
import java.util.Map;

import javax.imageio.ImageIO;
/*import javax.jnlp.FileContents;*/
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




/**
 * Servlet implementation class CodeServlet
 */
@WebServlet("/getcode")
public class CodeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 调用工具类生成的验证码和验证码图片
        Map<String, Object> codeMap = CodeUtil.generateCodeAndPic();

        // 将四位数字的验证码保存到Session中。
        HttpSession session = req.getSession();
        session.setAttribute("code", codeMap.get("code").toString());

        // 禁止图像缓存。
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setDateHeader("Expires", -1);

        resp.setContentType("image/jpeg");

        // 将图像输出到Servlet输出流中。
        ServletOutputStream sos;
        try {
            sos = resp.getOutputStream();
            /*
            * ImageIO默认是使用缓存目录，可以通过ImageIO.setUseCache(false)来设置，更改缓存策略，不使用文件目录缓存，使用内存缓存
            * */
            ImageIO.setUseCache(false);
           ImageIO.write((RenderedImage) codeMap.get("codePic"), "jpg", sos);
            sos.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}