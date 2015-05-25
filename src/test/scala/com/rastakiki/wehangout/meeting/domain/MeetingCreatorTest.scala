package com.rastakiki.wehangout.meeting.domain

import com.rastakiki.wehangout.meeting.infrastructure.InMemmoryMeetingRepository
import org.scalatest.{FlatSpec, Matchers}

class MeetingCreatorTest extends FlatSpec with Matchers {

  "A meeting host user " should " be able to create a meeting" in {
    val meetingRepository = new InMemmoryMeetingRepository
    val meetingCreator = new MeetingCreator(meetingRepository)
    val meetingFetcher = new MeetingFetcher(meetingRepository)
    meetingCreator.createMeeting(new MeetingBuilder()
      .withTitle("Software Crafmanship Meetup")
      .withDescription("Meetup for the craftman!")
      .withLocation(Location(20d, 20d))
      .build)

    meetingFetcher.getAllMeetings() should contain(new MeetingBuilder()
      .withTitle("Software Crafmanship Meetup")
      .withDescription("Meetup for the craftman!")
      .withLocation(Location(20d, 20d))
      .build)
  }

}
