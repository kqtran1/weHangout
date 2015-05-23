package com.rastakiki.wehangout.meeting

trait MeetingRepository {

  def findAll: Seq[Meeting]

  def save(meeting: Meeting)

}
