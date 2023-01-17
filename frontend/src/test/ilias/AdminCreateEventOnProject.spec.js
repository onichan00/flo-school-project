import {mount} from "@vue/test-utils";
import eventForm from "@/views/admin/project/ProjectSubmissionsDetail";

describe("Create event from admin side", () => {
    let wrapper;

    beforeEach(async () => {
        wrapper = mount(eventForm);
        await wrapper.setData({id: 1})
        await wrapper.vm.$nextTick();
    });


    it("Form with a list of all specialists should be rendered", () => {
        const inputFields = wrapper.findAll("input");
        expect(inputFields.length).toBe(4);

        const textArea = wrapper.findAll("textarea")
        expect(textArea.length).toBe(1);
    });

    it("Should update all corresponding variables with the correct data", async () => {
        const inputFields = wrapper.findAll("input");
        const textArea = wrapper.findAll("textarea")

        inputFields.at(0).setValue("Event title")
        inputFields.at(1).setValue("Event locatie")
        inputFields.at(2).setValue("2023-01-17 22:11:13.712")
        inputFields.at(3).setValue("2023-01-17 22:11:13.712")

        textArea.at(0).setValue("Event description")

        await wrapper.vm.$nextTick();

        expect(wrapper.vm.event.title).toBe("Event title")
        expect(wrapper.vm.event.location).toBe("Event locatie")
        expect(wrapper.vm.event.start).toBe("2023-01-17T22:11:13.712")
        expect(wrapper.vm.event.end).toBe("2023-01-17T22:11:13.712")

        expect(wrapper.vm.event.description).toBe("Event description")

    });
});
