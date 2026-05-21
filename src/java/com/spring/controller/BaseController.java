package com.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * 基本控制器路由基类
 * 主要处理路由中获取 request 和 response 类，加快开发进度
 * 处理一些弹出窗口信息，返回对如使用 showError 弹出一个窗口，并警告
 *
 */
public abstract class BaseController {

    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected HttpServletResponse response;

    @Autowired
    protected HttpSession session;

    protected ModelAndView mView;

    BaseController() {
        //request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        mView = new ModelAndView();
    }

    protected void setAttribute(String name, Object value) {
        request.setAttribute(name, value);
    }

    /**
     * 实现弹出窗，主要代码，需要更改弹出窗样式请在WebRoot\message.jsp 文件中修改
     * @param message
     * @param code
     * @param jumpUrl
     * @param jumpTime
     * @return
     */
    protected String showMessage(String message, int code, String jumpUrl, int jumpTime) {
        setAttribute("message", message);
        setAttribute("code", code);
        setAttribute("jumpUrl", jumpUrl);
        setAttribute("jumpTime", jumpTime);

        return "message";
    }

    /**
     * 检测是否都来
     * @return
     */
    protected boolean checkLogin() {
        if (request.getSession().getAttribute("username") == null || "".equals(request.getSession().getAttribute("username"))) {
            return false;
        }
        return true;
    }

    /**
     * 弹出错误窗口
     * @param message
     * @return
     */
    protected String showError(String message) {
        return showMessage(message, 1, "javascript:history(-1);", 2250);
    }

    /**
     * 弹出错误窗口
     * @param message
     * @param code
     * @return
     */
    protected String showError(String message, int code) {
        return showMessage(message, code, "javascript:history(-1);", 2250);
    }

    /**
     * 弹出错误窗口
     * @param message
     * @param url
     * @return
     */
    protected String showError(String message, String url) {
        return showMessage(message, 1, url, 2250);
    }

    /**
     * 弹出成功窗口
     * @param message
     * @return
     */
    protected String showSuccess(String message) {
        return showMessage(message, 0, request.getHeader("referer"), 2250);
    }

    /**
     * 弹出成功窗口
     * @param message
     * @param url
     * @return
     */
    protected String showSuccess(String message, String url) {
        return showMessage(message, 0, url, 2250);
    }
    
    // 模板方法：处理请求的完整流程
    /**
     * 处理请求的完整流程
     * @param viewName 视图名称
     * @param processor 请求处理器
     * @return 视图名称
     */
    protected String processRequest(String viewName, RequestProcessor processor) {
        try {
            // 1. 检查登录状态
            if (!checkLogin()) {
                return showError("请登录！", "./login.do");
            }
            
            // 2. 预处理
            preProcess();
            
            // 3. 执行具体业务逻辑（由子类实现）
            processor.process();
            
            // 4. 后处理
            postProcess();
            
            // 5. 返回视图
            return viewName;
        } catch (Exception e) {
            e.printStackTrace();
            return showError("操作失败：" + e.getMessage());
        }
    }
    
    // 预处理方法
    protected void preProcess() {
        // 默认实现，可由子类重写
        System.out.println("执行预处理...");
    }
    
    // 后处理方法
    protected void postProcess() {
        // 默认实现，可由子类重写
        System.out.println("执行后处理...");
    }
    
    // 请求处理器接口
    protected interface RequestProcessor {
        void process();
    }
}