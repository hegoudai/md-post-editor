<template>
  <div id="main">
    <h1>Md-Post-Editor</h1>
    <div style="display: block;text-align: left">
      图片目录：
        <el-input v-model="path" placeholder="默认根目录" style="display: inline-block;width: 180px;margin-bottom: 15px"></el-input>
    </div>
    <mavon-editor id="editor" 
    ref=md
    placeholder="开始编辑你的博客吧..." 
    @imgAdd="$imgAdd" 
    v-model="value"/>
  </div>
</template>

<script>
import axios from 'axios'
import ElInput from "element-ui/packages/input/src/input";

export default {
    components: {
        ElInput
    },
    name: 'App',
  data() {
    return {value: '', path: ''}
  },
  methods: {
    $imgAdd(post, $file) {
      var formdata = new FormData()
      formdata.append('image', $file)
      formdata.append('path', this.path)
      axios({
        method: 'POST',
        url: 'http://localhost:4001/upload',
        data: formdata,
        headers: { 'Content-Type': 'multipart/form-data' }
      }).then( resp => {
        this.$refs.md.$img2Url(post, resp.data);
      })
    }
  }
}
</script>

<style>
#main {
  text-align: center;
  margin-top: 60px;
}
#editor {
  height: 800px;
}
</style>
