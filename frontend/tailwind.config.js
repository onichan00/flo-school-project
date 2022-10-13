/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./index.html",'./public/**/*.html', './src/**/*.{vue,js,ts,jsx,tsx}', './node_modules/flowbite/**/*.js' ],
  theme: {
    extend: {
      colors: {
        florijnOrange: "#ec5a29",
        florijnGray: "#919194"
      }
    },
  },
  plugins: [
    require('flowbite/plugin')
  ]
}
