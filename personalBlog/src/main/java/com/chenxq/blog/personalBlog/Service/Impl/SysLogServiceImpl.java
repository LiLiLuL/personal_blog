package com.chenxq.blog.personalBlog.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.chenxq.blog.personalBlog.Domain.SysLog;
import com.chenxq.blog.personalBlog.Domain.SysLogExample;
import com.chenxq.blog.personalBlog.Domain.SysView;
import com.chenxq.blog.personalBlog.Domain.SysViewExample;
import com.chenxq.blog.personalBlog.Repository.SysLogMapper;
import com.chenxq.blog.personalBlog.Repository.SysViewMapper;
import com.chenxq.blog.personalBlog.Service.SysLogService;



/**
 * @Description:日志的service实现
 * @Author: chenxq
 * @CreateDate: 2019/4/8 10:14
 * @Version: 1.0
 */
@Service
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    SysLogMapper sysLogMapper;
    @Autowired
    SysViewMapper sysViewMapper;



    /**
     * 增加一条日志信息
     *
     * @param sysLog
     */

    public void addLog(SysLog sysLog) {
        sysLogMapper.insertSelective(sysLog);
    }

    /**
     * 增加一条访问量
     *
     * @param sysView
     */

    public void addView(SysView sysView) {
        sysViewMapper.insertSelective(sysView);
    }

    /**
     * 获取日志的总数量
     *
     * @return 日志的总数量
     */

    public int getLogCount() {
        SysLogExample example = new SysLogExample();
        return sysLogMapper.selectByExample(example).size();
    }

    /**
     * 返回当前网站的访问量
     *
     * @return
     */

    public int getViewCount() {
        SysViewExample example = new SysViewExample();
        return sysViewMapper.selectByExample(example).size();
    }

    /**
     * 返回所有的日志信息
     *
     * @return
     */

    public List<SysLog> listAllLog() {
        SysLogExample example = new SysLogExample();
        return sysLogMapper.selectByExample(example);
    }

    /**
     * 返回所有的访问信息
     *
     * @return
     */

    public List<SysView> listAllView() {
        SysViewExample example = new SysViewExample();
        return sysViewMapper.selectByExample(example);
    }
}
