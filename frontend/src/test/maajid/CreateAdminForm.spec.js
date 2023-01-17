import { shallowMount } from "@vue/test-utils";
import Form from "@/components/admin/CreateAdmins.vue";

describe("Create admin form", () => {
    let wrapper;

    beforeEach(() => {
        wrapper = shallowMount(Form);
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
        inputFields.at(5).setValue("password");

        await wrapper.vm.$nextTick();

        expect(wrapper.vm.first_name).toBe("John");
        expect(wrapper.vm.preposition).toBe("van");
        expect(wrapper.vm.last_name).toBe("Doe");
        expect(wrapper.vm.email).toBe("john@example.com");
        expect(wrapper.vm.phone).toBe("1234567890");
        expect(wrapper.vm.password).toBe("password");


    });

    // it('calls the submit method when the submit button is pressed', async () => {
    //     const inputFields = wrapper.findAll("input");
    //
    //
    //     // Create a mock function for the submit method
    //     inputFields.at(0).setValue("John");
    //     inputFields.at(1).setValue("van");
    //     inputFields.at(2).setValue("Doe");
    //     inputFields.at(3).setValue("john@example.com");
    //     inputFields.at(4).setValue("1234567890");
    //     inputFields.at(4).setValue("password");
    //
    //     let mockedFormSubmit = jest.spyOn(Form.methods, 'createRequest');
    //
    //     // Find the submit button and trigger a click event
    //     const submitButton = wrapper.find("#AanmakenKnop");
    //     await submitButton.trigger('click');
    //
    //     // Wait for the next tick to make sure the method call is processed
    //     await wrapper.vm.$nextTick();
    //
    //     // Assert that the submit method was called
    //     expect(mockedFormSubmit).toHaveBeenCalledTimes(1);
    //
    // });
});
