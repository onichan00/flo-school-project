import { mount } from "@vue/test-utils";
import AvailabilityRow from "@/components/miscellaneous/profile/AvailabilityRow.vue";

let wrapper;

beforeAll(() => {
    const propData = {
        time: {
            label: "Dinsdag",
            start: new Date(2022, 11, 12, 9, 0),
            end: new Date(2022, 11, 12, 17, 0),
            available: false
        }
    }


    wrapper = mount(AvailabilityRow, {
        props: propData
    })
})

describe('Sanity Test', function () {
    it('1 should equal 1', () => {
        expect(1).toBe(1);
    })
});

describe('Edit available hours', function () {
    it('Should emit saveAvailability when clicking on the available checkbox', () => {
        let emitEvent;
        const availableToggle = wrapper.find('#availableCheckbox');

        // Set the checkbox checked
        availableToggle.setChecked(true);

        // Check if the checkbox is checked
        expect(availableToggle.element.checked).toBeTruthy();

        // Catch the emit event
        emitEvent = wrapper.emitted('saveAvailability')[0][0];

        // The checkbox should be true
        expect(emitEvent.available).toEqual(true)

        // Set the checkbox unchecked
        availableToggle.setChecked(false);

        expect(availableToggle.element.checked).toBeFalsy();

        emitEvent = wrapper.emitted('saveAvailability')[0][0];

        expect(emitEvent.available).toEqual(false);
    });

    it('Should emit on start time change', () => {
        // Get the start time picker
        const startTimePicker = wrapper.findAll('input.mx-input').at(0);

        startTimePicker.element.value = new Date();
        startTimePicker.trigger('input');
        // startTimePicker.setValue(new Date());
        // console.log(wrapper.props());
        // console.log(wrapper.emitted('saveAvailability')[0][0]);


        // console.log(startTimePicker.element.value);
        // startTimePicker.setValue(new Date())
        // console.log(startTimePicker.element.value);
        //
        // console.log(wrapper.emitted('saveAvailability')[0][0]);

    });

    it.todo('Should emit on end time change');

    // it('should emit on end time change', () => {
    //     // const endTimePicker = wrapper.find('#endTimePicker')
    // });
});