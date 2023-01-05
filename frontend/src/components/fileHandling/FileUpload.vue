<template>
  <div class="relative container shadow-md border border-gray-200 sm:rounded-lg">
    <label for="file-input">Selecteer bestand: </label>
    <input ref="fileToUpload" type="file" id="file-input" @click="clearForm">
    <div v-if="uploadSuccessful" class="success-message text-xs">
      Bestand opgeslagen.
    </div>
    <div v-else class="success-message">

    </div>
    <div class="btn-container">
      <button
          class="save-btn"
          id="upload-file"
          @click.prevent="uploadFile">
      </button>
    </div>
  </div>
</template>

<script>
export default {
  name: "FileUpload",
  data() {
    return {
      uploadSuccessful: false,
      userId: localStorage.getItem("id"),
      fileId: ''
    }
  },
  methods: {
    uploadFile() {
      console.log(this.userId)
      const data = new FormData();
      data.append(
          "file",
          this.$refs.fileToUpload.files[0]
      );
      fetch(`${process.env.VUE_APP_API_URL}/api/files/upload/${this.userId}`, {
        method: "POST",
        body: data,
        headers: {
          "userId": this.userId
        }
      }).then(response => {
        if (response.ok) {
          this.uploadSuccessful = true;
          return response.json();
        }
      }).then(data => {
        this.fileId = data.id;
        this.$emit('fileId', this.fileId);
      })
    },
    clearForm() {
      this.uploadSuccessful = false;
      this.$refs.fileToUpload.value = null;
    }
  }
}
</script>

<style scoped>
.container {
  display: flex;
  flex-direction: column;
  align-items: start;
  max-width: 250px;
  padding: 10px 10px;
  gap: 10px;
  overflow: hidden;
}
.btn-container {
  display: flex;
  justify-content: flex-end;
  width: 100%;
}
.save-btn {
  background: center no-repeat url("@/assets/img/diskette.png") orange;
  background-size: 85%;
  width: 30px;
  height: 30px;
  border-radius: 5px;
}
.success-message {
  position: absolute;
  bottom: 5px;
  left: 10px;
}
#file-input {
  max-width: 230px;
}
</style>