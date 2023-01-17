import { mount } from "@vue/test-utils";
import Form from "@/components/admin/CreateAdmins.vue";

describe("Create admin form", () => {
    let wrapper;

    beforeEach(() => {
        wrapper = mount(Form);
    });

    it("should render the form with input fields for first name, preposition, last name, email, and phone", () => {
        const inputFields = wrapper.findAll("input");

        expect(inputFields.length).toBe(7);
        expect(inputFields.at(0).element.name).toBe("floating_first_name");
        expect(inputFields.at(1).element.name).toBe("floating_first_name");
        expect(inputFields.at(2).element.name).toBe("floating_last_name");
        expect(inputFields.at(3).element.name).toBe("email");
        expect(inputFields.at(4).element.name).toBe("phone");
    });

    it("should update the data properties when the input fields are changed", async () => {
        const inputFields = wrapper.findAll("input");

        inputFields.at(0).setValue("John");
        inputFields.at(1).setValue("van");
        inputFields.at(2).setValue("Doe");
        inputFields.at(3).setValue("john@example.com");
        inputFields.at(4).setValue("1234567890");

        await wrapper.vm.$nextTick();

        expect(wrapper.vm.first_name).toBe("John");
        expect(wrapper.vm.preposition).toBe("van");
        expect(wrapper.vm.last_name).toBe("Doe");
        expect(wrapper.vm.email).toBe("john@example.com");
        expect(wrapper.vm.phone).toBe("1234567890");
    });
});
