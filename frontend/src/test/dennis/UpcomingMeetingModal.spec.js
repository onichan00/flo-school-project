import {mount, shallowMount} from "@vue/test-utils";
import UpcomingMeetingModal from "@/components/modals/profile/UpcomingMeetingModal.vue";
import UpcomingMeeting from "@/models/upcomingMeeting";
import dateFormat from "dateformat";

let wrapper;

const open = false;
const user = {};
const meeting = new UpcomingMeeting();
const projects = [];

beforeAll(() => {
    wrapper = mount(UpcomingMeetingModal, {
        props: {
            open: open,
            user: user,
            meeting: meeting,
            projects: projects
        },
    });
})

describe('UpcomingMeetingModal', () => {
    it('Should emit an close event when close button is clicked', () => {
        wrapper.find('.modal__close').trigger('click');
        expect(wrapper.emitted().close).toBeTruthy();
    })

    it('Displays the correct title', () => {
        expect(wrapper.find('.modal__title').text()).toBe('Nieuwe activiteit');
    })

    it('Displays the correct start and end dates', () => {
        const start = new Date();
        const end = new Date();

        start.setHours(9);
        start.setMinutes(0);
        start.setSeconds(0);

        end.setHours(17);
        end.setMinutes(0);
        end.setSeconds(0);

        const startValue = dateFormat(start, "dd-mm-yyyy HH:MM");
        const endValue = dateFormat(end, "dd-mm-yyyy HH:MM");

        expect(wrapper.find('.meetingStart').element.value).toBe(startValue);
        expect(wrapper.find('.meetingEnd').element.value).toBe(endValue);
    })

    it('Should test if the notBeforeStartTime and notAfterEndTime function is working properly', () => {
        wrapper.setData({
            getMeeting: {
                start: new Date('2023-01-01T00:00:00.000Z'),
                end: new Date('2023-01-01T01:00:00.000Z'),
            }
        });

        expect(wrapper.vm.notBeforeStartTime(new Date('2024-01-01T00:00:00.000Z'))).toBe(false);
        expect(wrapper.vm.notBeforeStartTime(new Date('2023-01-02T00:00:00.000Z'))).toBe(true)

        expect(wrapper.vm.notAfterEndTime(new Date('2022-01-01T01:00:00.000Z'))).toBe(false)
        expect(wrapper.vm.notAfterEndTime(new Date('2023-02-01T01:00:00.000Z'))).toBe(true)
    });
})