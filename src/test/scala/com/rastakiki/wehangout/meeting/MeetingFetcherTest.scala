package com.rastakiki.wehangout.meeting

import org.scalatest.{GivenWhenThen, FeatureSpec, FlatSpec, Matchers}


class MeetingFetcherTest extends FlatSpec with Matchers {

  "Given an Anonymous user and an empty meeting list when user display meeting, user " should " see no meeting" in {
      val presentMeetingUseCase = new MeetingFetcher(new InMemmoryMeetingRepository)

      val meetings: Seq[Meeting] = presentMeetingUseCase.getAllMeetingForUser(new User)

      meetings shouldBe empty

  }

  "Given an Anonymous user and a meeting list when user display meeting, user " should " display all meetings" in {
      val meetingRepository = new InMemmoryMeetingRepository
      meetingRepository.save(new Meeting("Software Crafmanship Meetup"))
      meetingRepository.save(new Meeting("Java Performance Meetup"))

      val presentMeetingUseCase = new MeetingFetcher(meetingRepository)

      val meetings: Seq[Meeting] = presentMeetingUseCase.getAllMeetingForUser(new User)

      meetings should contain inOrder (new Meeting("Software Crafmanship Meetup"), new Meeting("Java Performance Meetup"))

  }


}
