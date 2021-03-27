#!/usr/bin/env python3
# -*- coding: utf-8 -*-

from app import db


class Forum(db.Model):

    __tablename__ = 'forum'

    id = db.Column(db.Integer, primary_key=True)  # id
    masterId = db.Column(db.String(255))
    name = db.Column(db.String(255))
    title = db.Column(db.String(255))

    def to_json(self):
        dict = self.__dict__
        if "_sa_instance_state" in dict:
            del dict["_sa_instance_state"]

        return dict


class Meeting(db.Model):

    __tablename__ = 'meeting'

    id = db.Column(db.Integer, primary_key=True)  # id
    masterId = db.Column(db.String(255))
    name = db.Column(db.String(255))
    title = db.Column(db.String(255))
    time = db.Column(db.String(255))
    agenda = db.Column(db.String(255))

    def to_json(self):
        dict = self.__dict__
        if "_sa_instance_state" in dict:
            del dict["_sa_instance_state"]

        return dict


class Message(db.Model):

    __tablename__ = 'message'

    id = db.Column(db.Integer, primary_key=True)  # id
    userid = db.Column(db.String(255))
    content = db.Column(db.String(255))
    title = db.Column(db.String(255))
    time = db.Column(db.String(255))
    forumid = db.Column(db.String(255))

    def to_json(self):
        dict = self.__dict__
        if "_sa_instance_state" in dict:
            del dict["_sa_instance_state"]

        return dict


class User(db.Model):

    __tablename__ = 'user'

    id = db.Column(db.Integer, primary_key=True)  # id
    password = db.Column(db.String(255))
    role = db.Column(db.String(255))
    userid = db.Column(db.String(255))

    def to_json(self):
        dict = self.__dict__
        if "_sa_instance_state" in dict:
            del dict["_sa_instance_state"]

        return dict


class Userforum(db.Model):

    __tablename__ = 'userforum'

    id = db.Column(db.Integer, primary_key=True)  # id
    userid = db.Column(db.String(255))
    forumid = db.Column(db.String(255))

    def to_json(self):
        dict = self.__dict__
        if "_sa_instance_state" in dict:
            del dict["_sa_instance_state"]

        return dict


# db.create_all()
# db.drop_all()
