package com.rastakiki.wehangout.meeting

class MeetingFetcher(val meetingRepository: MeetingRepository) {

  def getAllMeetingForUser(user: User): Seq[Meeting] = {
    meetingRepository.findAll
  }

}
