package com.chenxq.blog.personalBlog.SystemLog;

import java.lang.reflect.Method;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.chenxq.blog.personalBlog.Domain.SysLog;
import com.chenxq.blog.personalBlog.Service.SysLogService;
import com.chenxq.blog.personalBlog.Util.Result;
import com.chenxq.blog.personalBlog.Util.ResultEnum;
import com.chenxq.blog.personalBlog.Util.ResultUtil;

/**
 * @Description:定义日志切入类
 * @Author: chenxq
 * @CreateDate: 2019/4/8 9:58
 * @Version: 1.0
 */
 @Aspect
 @Component
 @Order(-5)
public class SystemLogAspect {
	  @Autowired
	    private SysLogService systemLogService;

	    /***
	     * 定义service切入点拦截规则，拦截SystemServiceLog注解的方法
	     */
	    @Pointcut("@annotation(com.chenxq.blog.personalBlog.SystemLog.SystemServiceLog)")
	    public void serviceAspect(){}

	    /***
	     * 定义controller切入点拦截规则，拦截SystemControllerLog注解的方法
	     */
	    @Pointcut("@annotation(com.chenxq.blog.personalBlog.SystemLog.SystemControllerLog)")
	    public void controllerAspect(){}

	    /***
	     * 拦截控制层的操作日志
	     * @param joinPoint
	     * @return
	     * @throws Throwable
	     */
	    @Around("controllerAspect()")
	    public Result  recordLog(ProceedingJoinPoint joinPoint) throws Throwable {
	        SysLog systemLog = new SysLog();
	        Object proceed = null ;
	        //获取session中的用户
	        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	        request.getSession().getAttribute("user");
	        String requestUrl=request.getRequestURL().toString();
	        systemLog.setOperate_url(requestUrl);
	        systemLog.setOperate_by("chenxiaoqing");
	        //获取请求的ip
	        String ip = request.getRemoteAddr();
	        systemLog.setIp(ip);
	        //获取方法执行前时间
	        Date date=new Date();
	        systemLog.setCreate_by(date);;

	        proceed = joinPoint.proceed();
	        //提取controller中ExecutionResult的属性
	       Result result = (Result) proceed;
	       String res="操作结果:"+result.getCode()+",";

	        if (result.getCode().equals(ResultEnum.SUCCESS)){
	            //设置操作信息
	        	
	            systemLog.setRemark(result.getMsg());
	        
	        }else{      
	            systemLog.setRemark(res+result.getMsg());
	        }
	        systemLogService.addLog(systemLog);
	        return result ;
	    }

	    //异常处理
	    @AfterThrowing(pointcut = "controllerAspect()",throwing="e")
	    public void doAfterThrowing(JoinPoint joinPoint,Throwable e) throws Throwable{
	        SysLog systemLog = new SysLog();
	        Object proceed = null ;
	        //获取session中的用户
	        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	        request.getSession().getAttribute("user");
	        systemLog.setOperate_by("chenxiaoqing");
	        //获取请求的ip
	        String ip = request.getRemoteAddr();
	        systemLog.setIp(ip);
	        systemLog.setRemark(e.getMessage());
	        systemLog.setOperate_url(e.getClass().getName());
	        systemLogService.addLog(systemLog);
	    }


	    /***
	     * 获取service的操作信息
	     * @param joinpoint
	     * @return
	     * @throws Exception
	     */
	    public String getServiceMethodMsg(JoinPoint joinpoint) throws Exception{
	        //获取连接点目标类名
	        String className =joinpoint.getTarget().getClass().getName() ;
	        //获取连接点签名的方法名
	        String methodName = joinpoint.getSignature().getName() ;
	        //获取连接点参数
	        Object[] args = joinpoint.getArgs() ;
	        //根据连接点类的名字获取指定类
	        Class targetClass = Class.forName(className);
	        //拿到类里面的方法
	        Method[] methods = targetClass.getMethods() ;

	        String description = "" ;
	        //遍历方法名，找到被调用的方法名
	        for (Method method : methods) {
	            if (method.getName().equals(methodName)){
	                Class[] clazzs = method.getParameterTypes() ;
	                if (clazzs.length==args.length){
	                    //获取注解的说明
	                    description = method.getAnnotation(SystemServiceLog. class).decription();
	                    break;
	                }
	            }
	        }
	        return description ;
	    }

	    /***
	     * 获取controller的操作信息
	     * @param point
	     * @return
	     */
	    public String getControllerMethodDescription(ProceedingJoinPoint point) throws  Exception{
	        //获取连接点目标类名
	        String targetName = point.getTarget().getClass().getName() ;
	        //获取连接点签名的方法名
	        String methodName = point.getSignature().getName() ;
	        //获取连接点参数
	        Object[] args = point.getArgs() ;
	        //根据连接点类的名字获取指定类
	        Class targetClass = Class.forName(targetName);
	        //获取类里面的方法
	        Method[] methods = targetClass.getMethods() ;
	        String description="" ;
	        for (Method method : methods) {
	            if (method.getName().equals(methodName)){
	                Class[] clazzs = method.getParameterTypes();
	                if (clazzs.length == args.length){
	                    description = method.getAnnotation(SystemControllerLog.class).description();
	                    break;
	                }
	            }
	        }
	        return description ;
	    }

	}

