<template>
  <li class="py-2 px-4 w-full flex flex-col md:flex-row justify-between items-center">
    <span class="flex flex-row gap-2 text-ellipsis">
      <svg class="w-5 h-5 text-gray-400" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M15.172 7l-6.586 6.586a2 2 0 102.828 2.828l6.414-6.586a4 4 0 00-5.656-5.656l-6.415 6.585a6 6 0 108.486 8.486L20.5 13"></path></svg>
      {{ formatName() }}
    </span>
    <button :id="getButtonId" @click="downloadFile" class="font-medium text-blue-600 hover:underline download">Download</button>
  </li>
</template>

<script>
import axios from "axios";
import {useToast} from "vue-toastification";

export default {
  name: "AttachmentRow",
  props: ['attachment'],
  computed: {
    getButtonId() {
      return `download-${this.attachment.name}`;
    }
  },
  methods: {
    downloadFile() {
      const URL = `${process.env.VUE_APP_API_URL || "http://localhost:8080"}/api/files/${this.attachment.id}`;
      const METHOD = "GET";
      const HEADERS = { "Content-Type": "application;octet-stream" }
      const RESPONSE_TYPE = "blob";

      console.log(URL);
      console.log(this.attachment);

      axios({ url: URL, method: METHOD, headers: HEADERS, responseType: RESPONSE_TYPE })
        .then((res) => {
          console.log("SEND", res);
          const HREF = window.URL.createObjectURL(res.data);
          const LINK = document.createElement("a");
          const FILE_NAME = this.formatName();

          LINK.href = HREF;
          LINK.download = FILE_NAME;
          LINK.click();
          LINK.remove();

          window.URL.revokeObjectURL(HREF);
        })
        .catch((err) => {
          console.log(err);
          useToast().error("Iets ging mis tijdens het downloaden van het bestand.");
        })
    },
    formatName() {
      return `${this.attachment.name}.${this.attachment.type.split("/")[1]}`;
    }
  }
}
</script>

<style scoped>

</style>