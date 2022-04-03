const port = 8080; // dev port
// All configuration item explanations can be find in https://cli.vuejs.org/config/
module.exports = {
  devServer: {
    port,
    host:"0.0.0.0",
    open: true,
    overlay: {
      warnings: false,
      errors: true
    },
    // ���ô��� ���Խӿ� https://www.easy-mock.com/mock/5ce2a7854c85c12abefbae0b/api ˵����
    // proxy: {
    //   "/api": {
    //     target: process.env.VUE_APP_URL,
    //     changeOrigin: true, // �Ƿ�ı�����
    //     ws: true
    //     // pathRewrite: {
    //     //   // ·����д
    //     //   "/api": "" // �����˼������api��ͷ�ģ���������, �����ĺ�߻���·���Ļ��� ���Զ�ƴ����
    //     // }
    //   }
    // }
    // �±������ ������Ǳ����Լ�mock �Ļ���after������ԣ����ϻ���һ��Ҫ�ɵ�
    // after: require("./mock/mock-server.js")
  }
};