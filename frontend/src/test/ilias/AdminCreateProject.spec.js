import {mount} from '@vue/test-utils'
import eventForm from "@/views/admin/project/ProjectSubmissionsDetail";


describe("Form", () => {
    let wrapper;


    beforeEach(async () => {
        wrapper = mount(eventForm);
        await wrapper.setData({id: 1})
        await wrapper.vm.$nextTick();

    });

    it("should render 3 input fields for first name, preposition and last name", () => {
        const inputFields = wrapper.findAll("input");
        const textArea = wrapper.findAll("textarea")

        expect(inputFields.length).toBe(4);
        expect(textArea.length).toBe(1);
    });

    it("Change the data", async () => {
        wrapper.setData({
            event: {
                title: "Event title",
            }
        });
        await wrapper.vm.$nextTick();
        expect(wrapper.find("#eventTitle").element.value).toBe("Event title");
    });
    it("Change the data", async () => {
        wrapper.setData({
            event: {
                location: "Event location"
            }
        });
        await wrapper.vm.$nextTick();
        expect(wrapper.find("#eventLocation").element.value).toBe("Event location");
    });

    it("Change the data", async () => {
        wrapper.setData({
            event: {
                start: "2023-01-17T22:11:13.712"
            }
        });
        await wrapper.vm.$nextTick();
        expect(wrapper.find("#eventStart").element.value).toBe("2023-01-17T22:11:13.712");
    });

    it("Change the data", async () => {
        wrapper.setData({
            event: {
                end: "2023-01-17T22:11:13.712"
            }
        });
        await wrapper.vm.$nextTick();
        expect(wrapper.find("#eventEnd").element.value).toBe("2023-01-17T22:11:13.712");
    });

    it("Change the data", async () => {
        wrapper.setData({
            event: {
                description: "Event description"
            }
        });
        await wrapper.vm.$nextTick();
        expect(wrapper.find("#eventDescription").element.value).toBe("Event description");
    });
});
