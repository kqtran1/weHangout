package com.rastakiki.wehangout.meeting.domain

class TestMeetingBuilder {

  var title = "Meeting Title"
  var description = "Meeting Description"
  var location: Location = Location(10d, 10d)

  def withTitle(meetingTitle: String): TestMeetingBuilder = {
    this.title = meetingTitle
    return this
  }

  def withDescription(meetingDescription: String): TestMeetingBuilder = {
    this.description = meetingDescription
    return this
  }


  def withLocation(meetingLocation: Location): TestMeetingBuilder = {
    this.location = meetingLocation
    return this
  }

  def build: Meeting = {
    return Meeting(title, description, location)
  }

}
