#!/usr/bin/env python3
# -*- coding: utf-8 -*-

from . import pages
from app import db, models
from flask import request, jsonify
from sqlalchemy import func, text
import re


# 注册
@pages.route('/register', methods=['POST'])
def register():
    re_dict = request.get_json()
    user_name = re_dict.get('username')
    pwd = re_dict.get('password')
    forum = re_dict.get('forumValue')

    user = models.User()
    user.userid = user_name
    user.password = pwd
    user.role = "用户"

    db.session.add(user)
    db.session.commit()

    user_id = models.User.query.filter_by(userid=user_name,
                                          password=pwd).first()
    user_id = user_id.id

    for f in forum:
        f = int(f)
        s = models.Forum.query.filter_by(id=f).first()
        user_forum = models.Userforum()
        user_forum.userid = user_id
        user_forum.forumid = s.id

        db.session.add(user_forum)
        db.session.commit()

    result = {}
    result['userid'] = user_id
    result['username'] = user.userid
    result['role'] = user.role

    return jsonify(errno=0, data=result)


# 登陆
@pages.route('/login', methods=['POST'])
def login():
    re_dict = request.get_json()
    user_name = re_dict.get('username')
    pwd = re_dict.get('password')

    user = models.User.query.filter_by(userid=user_name, password=pwd).first()

    if user is None:
        return jsonify(errno=404)

    result = {}
    result['userid'] = user.id
    result['username'] = user.userid
    result['role'] = user.role

    return jsonify(errno=0, data=result)


# 搜索论坛
@pages.route('/forum', methods=['GET'])
def showForum():
    forum = models.Forum.query.all()

    data = []
    for f in forum:
        d = {}
        d['id'] = f.id
        d['name'] = f.name
        data.append(d)

    return jsonify(errno=0, data=data)


# 显示会议信息
@pages.route('/meeting', methods=['GET'])
def showMeeting():
    m = models.Meeting.query.first()

    result = {}
    result['name'] = m.name
    result['time'] = m.time
    result['title'] = m.title
    result['agenda'] = m.agenda

    p = models.User.query.count()
    result['num'] = p

    forum = models.Forum.query.all()

    data = []
    for f in forum:
        d = {}
        d['name'] = f.name
        count = models.Userforum.query.filter_by(forumid=f.id).count()
        d['count'] = count

        data.append(d)

    result['list'] = data

    return jsonify(errno=0, data=result)


# 发布信息
@pages.route('/insert', methods=['POST'])
def insertMessage():
    re_dict = request.get_json()
    title = re_dict.get('title')
    forum_id = re_dict.get('forum_id')
    content = re_dict.get('content')
    date = re_dict.get('date')
    user_id = re_dict.get('user_id')

    message = models.Message()
    message.userid = user_id
    message.forumid = forum_id
    message.time = date
    message.title = title
    message.content = content

    db.session.add(message)
    db.session.commit()

    return jsonify(errno=0)


# 获取人员信息
@pages.route('/person/<forum_id>', methods=['GET'])
def showPerson(forum_id):
    users = models.Userforum.query.filter_by(forumid=forum_id)
    forum = models.Forum.query.filter_by(id=forum_id).first()

    result = []
    for u in users:
        d = {}
        m = models.User.query.filter_by(id=u.userid).first()
        d['id'] = m.id
        d['username'] = m.userid
        d['forum'] = forum.name

        result.append(d)

    return jsonify(errno=0, data=result)


# 获取论坛信息
@pages.route('/message/<forum_id>', methods=['GET'])
def showForumMessage(forum_id):
    forum = models.Forum.query.filter_by(id=forum_id).first()

    result = {}
    result['name'] = forum.name
    master = forum.masterId
    person = models.User.query.filter_by(id=master).first().userid
    result['userid'] = person

    num = models.Userforum.query.filter_by(forumid=forum_id).count()
    result['num'] = num

    forum_list = models.Message.query.filter_by(forumid=forum_id).all()

    data = []
    for f in forum_list:
        d = {}
        d['id'] = f.id
        d['userid'] = f.userid
        d['forumid'] = f.forumid
        d['content'] = f.content
        d['time'] = f.time

        data.append(d)

    result['list'] = data

    return jsonify(errno=0, data=result)
