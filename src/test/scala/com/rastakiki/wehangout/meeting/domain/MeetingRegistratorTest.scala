package com.rastakiki.wehangout.meeting.domain

import com.rastakiki.wehangout.meeting.infrastructure.InMemmoryMeetingRepository
import org.scalatest.{FlatSpec, Matchers}

class MeetingRegistratorTest extends FlatSpec with Matchers {

  "A meeting host user " should " be able to create a meeting" in {
    val meetingRepository = new InMemmoryMeetingRepository
    val meetingCreator = new MeetingCreator(meetingRepository)
    val meetingFetcher = new MeetingFetcher(meetingRepository)
    meetingCreator.createMeeting(new TestMeetingBuilder()
      .withTitle("Software Crafmanship Meetup")
      .withDescription("Meetup for the craftman!")
      .withLocation(Location(20d, 20d))
      .build)

    meetingFetcher.getAllMeetings() should contain(new TestMeetingBuilder()
      .withTitle("Software Crafmanship Meetup")
      .withDescription("Meetup for the craftman!")
      .withLocation(Location(20d, 20d))
      .build)
  }

}
