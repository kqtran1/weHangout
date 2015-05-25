package com.rastakiki.wehangout.meeting.domain

trait MeetingRepository {

  def findAll: Seq[Meeting]

  def save(meeting: Meeting)

}
