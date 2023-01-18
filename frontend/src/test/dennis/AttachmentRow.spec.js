import {mount, shallowMount} from "@vue/test-utils";
import AttachmentRow from "@/components/miscellaneous/profile/AttachmentRow.vue";
import axios from "axios";

let wrapper;
const attachment = { id: "123", name: "example", type: "application/pdf" };

beforeAll(() => {
    wrapper = mount(AttachmentRow, {
        props: { attachment }
    });

    jest.spyOn(axios, 'get').mockResolvedValue(attachment);
});

beforeEach(() => {
    axios.get();
})


describe('AttachmentRow', () => {
    it.skip('downloadFile should make a GET request to the correct URL', async () => {
        // const mockAxios = jest.spyOn(axios, "get");
        await wrapper.vm.downloadFile();

        expect(axios.get).toHaveBeenCalledTimes(1);
    })

    it.skip('downloadFile should create a link element with the correct href and download attributes', async () => {
        const mockCreateObjectURL = jest.spyOn(window.URL, "createObjectURL");
        const mockCreateElement = jest.spyOn(document, "createElement");

        wrapper.vm.downloadFile();

        expect(mockCreateObjectURL).toHaveBeenCalledWith({ data: 'blob' });
        expect(mockCreateElement).toHaveBeenCalledWith("a");

        expect(mockCreateElement.mock.results[0].value.href).toEqual("objectURL");
        expect(mockCreateElement.mock.results[0].value.download).toEqual("example.pdf")
    })

    it.skip('downloadFile should revoke the object URL when the download is complete', async () => {
        const mockRevokeObjectURL = jest.spyOn(window.URL, "revokeObjectURL");

        wrapper.vm.downloadFile();
        expect(mockRevokeObjectURL).toHaveBeenCalledWith("objectURL");
    })

    it.skip('formatName should return the correct file name', async () => {
        expect(wrapper.vm.formatName()).toEqual("example.pdf");
    })

    it.skip('getButtonId should return the correct button id', async () => {
        expect(wrapper.vm.getButtonId()).toEqual("download-example");
    })
});