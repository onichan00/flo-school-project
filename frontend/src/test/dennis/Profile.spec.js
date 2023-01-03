import { mount } from "@vue/test-utils";
import Profile from "@/views/admin/profile.vue";

let wrapper;

beforeAll(() => {
    const mockRoute = {
        params: {
            id: 3
        }
    }

    wrapper = mount(Profile, {
        global: {
            mocks: {
                $route: mockRoute
            }
        }
    });
})

describe('Sanity test', function () {
    it('1 should equal 1', () => {
        expect(1).toBe(1);
    })
});

describe('Template tests', function () {
    // Test that the "Loading" message is displayed when userObj is falsy.
    it.todo('The loading message should display');

    // Test that the userFullName function correctly concatenates the firstName and lastName properties of the userObj object.
    it.todo('userFullName should correctly concatenate the full name of the user');

    // Test that the firstLetterUpperCase function correctly capitalizes the first letter of the string passed to it.
    it.todo('firstLetterUpperCase should correctly capitalize the first letter');

    // Test that the AttachmentRow component is displayed for each attachment in the attachments array.
    it.todo('The AttachmentRow component should display for each attachment');

    // Test that the UpcomingMeetingModal component is displayed when the upcomingMeetingModalOpen property is truthy, and that it is hidden when upcomingMeetingModalOpen is falsy.
    it.todo('When the upcomingMeetingModalOpen is true it should display UpcomingMeetingModal');

    // Test that the EditUserInfoModal component is displayed when the editUserInfoModalOpen property is truthy, and that it is hidden when editUserInfoModalOpen is falsy.
    it.todo('When the editUserInfoModalOpen is true it should display EditUserInfoModal');

    // Test that the SkillModal component is displayed when the skillModalOpen property is truthy, and that it is hidden when skillModalOpen is falsy.
    it.todo('When the skillModalOpen is true it should display SkillModal');

    // Test that the "Skills" section is only displayed when userObj.userType is equal to 2.
    it.todo('The Skills section should only be displayed when the userType is equal to 2');

    it.todo('Test that the attributes computed property correctly formats the events in the userObj.specialist.events array.');

    it.todo('Test that the availableHours computed property correctly calculates the total number of available hours from the hours array.');

    it.todo('Test that the eventsInDateRange computed property correctly filters the events in the attributes array to only include events within the specified date range.');

    it.todo('Test that the goToNextWeek method correctly increments the selectedWeek property by one week.');

    it.todo('Test that the goToPrevWeek method correctly decrements the selectedWeek property by one week.');

    it.todo('Test that the meetingFormat method correctly formats a meeting object to be compatible with the FullCalendar component.');

    it.todo('Test that the openMeetingModal method sets the upcomingMeetingModalOpen property to true and sets the selectedMeeting property to the correct meeting object.');

    it.todo('Test that the openEditUserInfoModal method sets the editUserInfoModalOpen property to true.');

    it.todo('Test that the openSkillModal method sets the skillModalOpen property to true and sets the selectedSkill property to the correct skill object.');

    it.todo('Test that the createMeeting method correctly adds a new meeting to the attributes array.');

});