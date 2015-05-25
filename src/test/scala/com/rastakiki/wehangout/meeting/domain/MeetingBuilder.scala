package com.rastakiki.wehangout.meeting.domain

class MeetingBuilder {

  var title = "Meeting Title"
  var description = "Meeting Description"
  var location: Location = Location(10d, 10d)

  def withTitle(meetingTitle: String): MeetingBuilder = {
    this.title = meetingTitle
    return this
  }

  def withDescription(meetingDescription: String): MeetingBuilder = {
    this.description = meetingDescription
    return this
  }


  def withLocation(meetingLocation: Location): MeetingBuilder = {
    this.location = meetingLocation
    return this
  }

  def build: Meeting = {
    return Meeting(title, description, location)
  }

}
