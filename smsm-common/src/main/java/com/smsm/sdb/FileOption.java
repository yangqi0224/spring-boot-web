package com.smsm.sdb;

import com.sequoiacm.client.core.*;
import com.sequoiacm.client.element.ScmId;
import com.sequoiacm.client.element.bizconf.ScmWorkspaceConf;
import com.sequoiacm.common.ScmArgChecker;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.jca.work.WorkManagerTaskExecutor;

import java.util.ArrayList;
import java.util.List;

public class FileOption {

    @Test
    public ScmId upLoadFile(){
        List<String> urlList = new ArrayList<String>();
        urlList.add("47.102.127.77:8080/rootsite");
        ScmSession session = null;
        ScmWorkspace ws = null;
        ScmFile file = null;
        ScmId id = null;
        try {
            ScmConfigOption conf = new ScmConfigOption(urlList,"admin","admin");
            session = ScmFactory.Session.createSession(conf);
            ScmWorkspaceConf wsconf = new ScmWorkspaceConf();
            ws = ScmFactory.Workspace.createWorkspace(session,wsconf);
            file = ScmFactory.File.createInstance(ws);
            file.setFileName("name");
            file.setAuthor("yangqi");
            file.setContent("C:\\Users\\杨旗\\Desktop\\smsm.sql");
            id = file.save();

        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(session.getSessionId()+"---------------------------"+session.getUrl());
        session.close();

        return id;

    }

    @Test
    public void downLoadFile(){
        ScmId id = upLoadFile();

        System.out.println(id);
    }
}
