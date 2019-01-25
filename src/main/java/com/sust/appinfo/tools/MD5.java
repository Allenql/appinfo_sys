package com.sust.appinfo.tools;

import org.python.core.PyFunction;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.util.PythonInterpreter;

/**
 * MD5加密
 */
public class MD5 {
    /**
     * 对用户密码进行加密处理
     * @param pwd
     * @return
     */
    public static String md5(String pwd){
        PythonInterpreter pi = new PythonInterpreter();
        pi.execfile("D:\\毕业设计-app信息管理平台\\appinfo_sys\\src\\main\\java\\com\\sust\\appinfo\\tools\\md5.py");
        PyFunction pf = pi.get("md5",PyFunction.class);
        PyObject py = pf.__call__(new PyString(pwd));
        return py.toString();
    }
}
