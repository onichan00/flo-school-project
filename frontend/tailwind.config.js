/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./index.html",'./public/**/*.html', './src/**/*.{vue,js,ts,jsx,tsx}', './node_modules/flowbite/**/*.js' ],
  theme: {
    colors: {},
    extend: {},
  },
  plugins: [
    require('flowbite/plugin')
  ]
}
