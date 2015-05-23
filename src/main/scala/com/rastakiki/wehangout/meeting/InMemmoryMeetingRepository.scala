package com.rastakiki.wehangout.meeting

import scala.collection.mutable

class InMemmoryMeetingRepository extends MeetingRepository {

  val meetings = new mutable.MutableList[Meeting]

  def save(meeting: Meeting) = {
    meetings += meeting
  }

  override def findAll: Seq[Meeting] = {
    return meetings.toList
  }
}
