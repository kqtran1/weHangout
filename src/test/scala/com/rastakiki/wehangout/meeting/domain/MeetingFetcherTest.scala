package com.rastakiki.wehangout.meeting.domain

import com.rastakiki.wehangout.meeting.infrastructure.InMemmoryMeetingRepository
import org.scalatest.{FlatSpec, Matchers}


class MeetingFetcherTest extends FlatSpec with Matchers {

  "Given an Anonymous user and an empty meeting list when user display meeting, user " should " see no meeting" in {
      val presentMeetingUseCase = new MeetingFetcher(new InMemmoryMeetingRepository)

      val meetings: Seq[Meeting] = presentMeetingUseCase.getAllMeetings()

      meetings shouldBe empty

  }

  "Given an Anonymous user and a meeting list when user display meeting, user " should " display all meetings" in {
      val meetingRepository = new InMemmoryMeetingRepository
      meetingRepository.save((new MeetingBuilder().withTitle("Software Crafmanship Meetup").build))
      meetingRepository.save((new MeetingBuilder().withTitle("Java Performance Meetup").build))

      val presentMeetingUseCase = new MeetingFetcher(meetingRepository)

      val meetings: Seq[Meeting] = presentMeetingUseCase.getAllMeetings()

      meetings should contain inOrder (
        new MeetingBuilder().withTitle("Software Crafmanship Meetup").build,
        new MeetingBuilder().withTitle("Java Performance Meetup").build)
  }

}
