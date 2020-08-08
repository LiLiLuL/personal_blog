package com.chenxq.blog.personalBlog.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chenxq.blog.personalBlog.Domain.SysLog;
import com.chenxq.blog.personalBlog.Domain.SysView;

/**
 * @Description:日志的service
 * @Author: chenxq
 * @CreateDate: 2019/4/8 10:14
 * @Version: 1.0
 */

public interface SysLogService {
	void addLog(SysLog sysLog);

    void addView(SysView sysView);

    int getLogCount();

    int getViewCount();

    List<SysLog> listAllLog();

    List<SysView> listAllView();

}
