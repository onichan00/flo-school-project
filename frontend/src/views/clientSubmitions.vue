<template>
    <input type="hidden" name="sort" value="<%= sort %>">
    <input type="hidden" name="order" value="<%= order %>">
    <input type="hidden" name="page" value="<%= page %>">
    <div class="-my-2 overflow-x-auto sm:-mx-6 lg:-mx-8">
      <div class="py-2 align-middle inline-block min-w-full sm:px-6 lg:px-8">
        <div class="overflow-hidden border-b border-slate-200">
          <table class="min-w-full divide-y divide-slate-200 border-t border-t-slate-200">
            <thead>
            <tr>
              <th scope="col"
                  class="cursor-pointer px-8 py-3 text-xs font-medium text-slate-500 tracking-wider">
                <div class="flex items-center space-x-1">
                  <div>Naam</div>
                </div>
              </th>
              <th scope="col"
                  class="cursor-pointer px-8 py-3 text-xs font-medium text-slate-500 tracking-wider">
                <div class="flex items-center space-x-1">
                  <div>Telefoon</div>
                </div>
              </th>
              <th scope="col"
                  class="cursor-pointer px-8 py-3 text-xs font-medium text-slate-500 tracking-wider">
                <div class="flex items-center space-x-1">
                  <div>Email</div>
                </div>
              </th>
              <th scope="col"
                  class="cursor-pointer px-8 py-3 text-xs font-medium text-slate-500 tracking-wider">
                <div class="flex items-center space-x-1">
                  <div>Date</div>
                </div>
              </th>
              <th scope="col"
                  class="cursor-pointer px-8 py-3 text-xs font-medium text-slate-500 tracking-wider">
                <div class="flex items-center space-x-1">
                  <div>Actions</div>
                </div>
              </th>
            </tr>
            </thead>
            <tbody class="bg-white divide-y divide-slate-200">
            <tr data-order-code="<%= order.id %>" class="text-slate-500 hover:bg-slate-100 cursor-pointer">
              <td class="px-8 py-4 whitespace-nowrap">
                <div class="flex items-center">
                  <div class="text-sm font-medium text-slate-900">
                    <p>Peter de Vries</p>
                  </div>
                </div>
              </td>
              <td class="px-8 py-4 whitespace-nowrap">
                <div class="flex items-center">
                  <div class="text-sm font-medium text-slate-900">
                    <p>0678231728</p>
                  </div>
                </div>
              </td>
              <td class="px-8 py-4 whitespace-nowrap">
                <div class="flex items-center">
                  <div class="text-sm font-medium text-slate-900">
                    <p>email@gmail.com</p>
                  </div>
                </div>
              </td>
              <td class="px-8 py-4 whitespace-nowrap">
                <div class="flex items-center">
                  <div class="text-sm font-medium text-slate-900">
                    <p>email@gmail.com</p>
                  </div>
                </div>
              </td>
              <td class="px-8 py-4 whitespace-nowrap">
                <div class="flex items-center">
                  <button type="button" data-order-edit class="p-1 hover:bg-slate-200 rounded-md">
                    <i class="fa-regular fa-circle-check text-2xl text-green-600"></i>
                  </button>
                  <button type="button" data-order-delete class="p-1 hover:bg-slate-200 rounded-md">
                    <i class="fa-regular fa-circle-xmark text-2xl text-red-600"></i>
                  </button>
                </div>

              </td>
            </tr>
            <tr data-order-code="<%= order.id %>" class="text-slate-500 hover:bg-slate-100 cursor-pointer">
              <td class="px-8 py-4 whitespace-nowrap">
                <div class="flex items-center">
                  <div class="text-sm font-medium text-slate-900">
                    <p>Peter de Vries</p>
                  </div>
                </div>
              </td>
              <td class="px-8 py-4 whitespace-nowrap">
                <div class="flex items-center">
                  <div class="text-sm font-medium text-slate-900">
                    <p>0678231728</p>
                  </div>
                </div>
              </td>
              <td class="px-8 py-4 whitespace-nowrap">
                <div class="flex items-center">
                  <div class="text-sm font-medium text-slate-900">
                    <p>email@gmail.com</p>
                  </div>
                </div>
              </td>
              <td class="px-8 py-4 whitespace-nowrap">
                <div class="flex items-center">
                  <div class="text-sm font-medium text-slate-900">
                    <p>email@gmail.com</p>
                  </div>
                </div>
              </td>
              <td class="px-8 py-4 whitespace-nowrap">
                <div class="flex items-center">
                  <button type="button" data-order-edit class="p-1 hover:bg-slate-200 rounded-md">
                    <i class="fa-regular fa-circle-check text-2xl text-green-600"></i>
                  </button>
                  <button type="button" data-order-delete class="p-1 hover:bg-slate-200 rounded-md">
                    <i class="fa-regular fa-circle-xmark text-2xl text-red-600"></i>
                  </button>
                </div>

              </td>
            </tr>
            <tr data-order-code="<%= order.id %>" class="text-slate-500 hover:bg-slate-100 cursor-pointer">
              <td class="px-8 py-4 whitespace-nowrap">
                <div class="flex items-center">
                  <div class="text-sm font-medium text-slate-900">
                    <p>Peter de Vries</p>
                  </div>
                </div>
              </td>
              <td class="px-8 py-4 whitespace-nowrap">
                <div class="flex items-center">
                  <div class="text-sm font-medium text-slate-900">
                    <p>0678231728</p>
                  </div>
                </div>
              </td>
              <td class="px-8 py-4 whitespace-nowrap">
                <div class="flex items-center">
                  <div class="text-sm font-medium text-slate-900">
                    <p>email@gmail.com</p>
                  </div>
                </div>
              </td>
              <td class="px-8 py-4 whitespace-nowrap">
                <div class="flex items-center">
                  <div class="text-sm font-medium text-slate-900">
                    <p>email@gmail.com</p>
                  </div>
                </div>
              </td>
              <td class="px-8 py-4 whitespace-nowrap">
                <div class="flex items-center">
                  <button type="button" data-order-edit class="p-1 hover:bg-slate-200 rounded-md">
                    <i class="fa-regular fa-circle-check text-2xl text-green-600"></i>
                  </button>
                  <button type="button" data-order-delete class="p-1 hover:bg-slate-200 rounded-md">
                    <i class="fa-regular fa-circle-xmark text-2xl text-red-600"></i>
                  </button>
                </div>

              </td>
            </tr>
            <tr data-order-code="<%= order.id %>" class="text-slate-500 hover:bg-slate-100 cursor-pointer">
              <td class="px-8 py-4 whitespace-nowrap">
                <div class="flex items-center">
                  <div class="text-sm font-medium text-slate-900">
                    <p>Peter de Vries</p>
                  </div>
                </div>
              </td>
              <td class="px-8 py-4 whitespace-nowrap">
                <div class="flex items-center">
                  <div class="text-sm font-medium text-slate-900">
                    <p>0678231728</p>
                  </div>
                </div>
              </td>
              <td class="px-8 py-4 whitespace-nowrap">
                <div class="flex items-center">
                  <div class="text-sm font-medium text-slate-900">
                    <p>email@gmail.com</p>
                  </div>
                </div>
              </td>
              <td class="px-8 py-4 whitespace-nowrap">
                <div class="flex items-center">
                  <div class="text-sm font-medium text-slate-900">
                    <p>email@gmail.com</p>
                  </div>
                </div>
              </td>
              <td class="px-8 py-4 whitespace-nowrap">
                <div class="flex items-center">
                  <button type="button" data-order-edit class="p-1 hover:bg-slate-200 rounded-md">
                    <i class="fa-regular fa-circle-check text-2xl text-green-600"></i>
                  </button>
                  <button type="button" data-order-delete class="p-1 hover:bg-slate-200 rounded-md">
                    <i class="fa-regular fa-circle-xmark text-2xl text-red-600"></i>
                  </button>
                </div>

              </td>
            </tr>
            <tr data-order-code="<%= order.id %>" class="text-slate-500 hover:bg-slate-100 cursor-pointer">
              <td class="px-8 py-4 whitespace-nowrap">
                <div class="flex items-center">
                  <div class="text-sm font-medium text-slate-900">
                    <p>Peter de Vries</p>
                  </div>
                </div>
              </td>
              <td class="px-8 py-4 whitespace-nowrap">
                <div class="flex items-center">
                  <div class="text-sm font-medium text-slate-900">
                    <p>0678231728</p>
                  </div>
                </div>
              </td>
              <td class="px-8 py-4 whitespace-nowrap">
                <div class="flex items-center">
                  <div class="text-sm font-medium text-slate-900">
                    <p>email@gmail.com</p>
                  </div>
                </div>
              </td>
              <td class="px-8 py-4 whitespace-nowrap">
                <div class="flex items-center">
                  <div class="text-sm font-medium text-slate-900">
                    <p>email@gmail.com</p>
                  </div>
                </div>
              </td>
              <td class="px-8 py-4 whitespace-nowrap">
                <div class="flex items-center">
                  <button type="button" data-order-edit class="p-1 hover:bg-slate-200 rounded-md">
                    <i class="fa-regular fa-circle-check text-2xl text-green-600"></i>
                  </button>
                  <button type="button" data-order-delete class="p-1 hover:bg-slate-200 rounded-md">
                    <i class="fa-regular fa-circle-xmark text-2xl text-red-600"></i>
                  </button>
                </div>

              </td>
            </tr>
            <tr data-order-code="<%= order.id %>" class="text-slate-500 hover:bg-slate-100 cursor-pointer">
              <td class="px-8 py-4 whitespace-nowrap">
                <div class="flex items-center">
                  <div class="text-sm font-medium text-slate-900">
                    <p>Peter de Vries</p>
                  </div>
                </div>
              </td>
              <td class="px-8 py-4 whitespace-nowrap">
                <div class="flex items-center">
                  <div class="text-sm font-medium text-slate-900">
                    <p>0678231728</p>
                  </div>
                </div>
              </td>
              <td class="px-8 py-4 whitespace-nowrap">
                <div class="flex items-center">
                  <div class="text-sm font-medium text-slate-900">
                    <p>email@gmail.com</p>
                  </div>
                </div>
              </td>
              <td class="px-8 py-4 whitespace-nowrap">
                <div class="flex items-center">
                  <div class="text-sm font-medium text-slate-900">
                    <p>email@gmail.com</p>
                  </div>
                </div>
              </td>
              <td class="px-8 py-4 whitespace-nowrap">
                <div class="flex items-center">
                  <button type="button" data-order-edit class="p-1 hover:bg-slate-200 rounded-md">
                    <i class="fa-regular fa-circle-check text-2xl text-green-600"></i>
                  </button>
                  <button type="button" data-order-delete class="p-1 hover:bg-slate-200 rounded-md">
                    <i class="fa-regular fa-circle-xmark text-2xl text-red-600"></i>
                  </button>
                </div>

              </td>
            </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
</template>

<script>
export default {
  name: "ClientSubmitions"
}
</script>

<style scoped>

</style>