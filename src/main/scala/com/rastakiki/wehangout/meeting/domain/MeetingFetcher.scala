package com.rastakiki.wehangout.meeting.domain

class MeetingFetcher(val meetingRepository: MeetingRepository) {

  def getAllMeetings(): Seq[Meeting] = {
    meetingRepository.findAll
  }

}
