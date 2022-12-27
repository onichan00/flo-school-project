import { mount } from "@vue/test-utils";
import UpcomingMeeting from "@/components/miscellaneous/profile/UpcomingMeeting.vue";

let wrapper;

beforeAll(() => {
    const propData = {
        meeting: {
            title: "Meeting with Apple",
            start: new Date(2022, 11, 8, 17, 0),
            end: new Date(2022, 11, 8, 18, 0),
            location: "Starbucks",
            description: "LOREM IPSUM DESCRIPTION",
            type: 0
        }
    }

    wrapper = mount(UpcomingMeeting, {
        props: propData
    })
})

describe('Upcoming Meeting', () => {
    it('Should emit open on click', () => {
        // Click on the meeting
        wrapper.trigger("click");

        // Catch the emit event
        const wrapperEvent = wrapper.emitted('meetingClicked')[0][0];

        // The emit event should have been called
        expect(wrapperEvent).toBeTruthy();
    })
})