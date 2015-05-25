package com.rastakiki.wehangout.meeting.domain

class MeetingCreator(val meetingRepository: MeetingRepository) {

  def createMeeting(meeting: Meeting): Unit = {
    meetingRepository.save(meeting)
  }

}
