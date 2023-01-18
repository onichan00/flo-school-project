import { shallowMount } from "@vue/test-utils";
import Form from "@/components/admin/CreateAdmins.vue";

describe("Create admin form", () => {
    let wrapper;

    // instantiating data before each test, using shallowmount because no extra data is necessary
    beforeEach(() => {
        wrapper = shallowMount(Form);
    });

    // checks for all the fields
    it("should render the form with input fields ", () => {
        // finds all fields
        const inputFields = wrapper.findAll("input");

        // checks if the amount of fields on fe match
        expect(inputFields.length).toBe(7);

        // checks id of fields match
        expect(inputFields.at(0).element.name).toBe("floating_first_name");
        expect(inputFields.at(1).element.name).toBe("floating_first_name");
        expect(inputFields.at(2).element.name).toBe("floating_last_name");
        expect(inputFields.at(3).element.name).toBe("email");
        expect(inputFields.at(4).element.name).toBe("phone");
        expect(inputFields.at(5).element.name).toBe("password");
    });

    // inputting data on fe and checking if the data objects change
    it("should update the data properties when the input fields are changed", async () => {
        const inputFields = wrapper.findAll("input");

        // inputting data on fe
        inputFields.at(0).setValue("John");
        inputFields.at(1).setValue("van");
        inputFields.at(2).setValue("Doe");
        inputFields.at(3).setValue("john@example.com");
        inputFields.at(4).setValue("1234567890");
        inputFields.at(5).setValue("password");

        await wrapper.vm.$nextTick();

        // checking if data in dataobjects match fe
        expect(wrapper.vm.first_name).toBe("John");
        expect(wrapper.vm.preposition).toBe("van");
        expect(wrapper.vm.last_name).toBe("Doe");
        expect(wrapper.vm.email).toBe("john@example.com");
        expect(wrapper.vm.phone).toBe("1234567890");
        expect(wrapper.vm.password).toBe("password");


    });
});
