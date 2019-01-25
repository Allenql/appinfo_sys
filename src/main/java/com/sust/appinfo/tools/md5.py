#-*- coding:utf-8 -*-
import hashlib

def md5(pwd):
    h = hashlib.md5()
    h.update(pwd.encode())
    return h.hexdigest()
