var users = [
  {firstName: "Richard", username: "thiccyriccky", id:"253"},
  {firstName: "Richrd", username: "thiccriccky", id:"253"},
  {firstName: "Rihard", username: "thiccyricky", id:"253"},
  {firstName: "Rihrd", username: "thiccyriccy", id:"253"},
]
function renderUsers(users) {
  var tableRows = jQuery("#table-rows")
  for(var i=0; i<users.length; i++) {
    var user = users[i]
    tableRows.append(`
      <tr>
          <td>${user.username}</td>
          <td>&nbsp;</td>
          <td>${user.firstName}</td>
          <td>Lovelace</td>
          <td>${user.id}</td>
          <td>
            <span class="pull-right">
            <i class="fa-2x fa fa-times wbdv-remove"></i>
            <i class="fa-2x fa fa-pencil wbdv-edit"></i>
            </span>
          </td>
        </tr>`);
  }
}

renderUsers(users)









/*(function () {

  const userService = new UserService();
  const rowTemplate = jQuery('wbdv-template');
  const tbody = jQuery('tbody');

  jQuery(main);

  function main() {
    userService
      .findAllUsers()
      .then(renderUsers);

  }

  function renderUsers(users) {
    for (const u in users) {
      const user = users[u];
      const rowClone = rowTemplate.clone();
      rowClone.removeClass('wbdv-hidden');
      rowClone.find('.wbdv-username').html(user.username);
      tbody.append(rowClone);
    }
  }
})()
(function () {
  var $usernameFld, $passwordFld;
  var $firstNameFld, $lastNameFld, $roleFld;
  var $removeBtn, $editBtn, $createBtn;
  var $userRowTemplate, $tbody;
  var userService = new AdminUserServiceClient();
  var users = [
    {firstName: "Richard", username: "thiccyriccky", id:"253"},
    {firstName: "Richrd", username: "thiccriccky", id:"253"},
    {firstName: "Rihard", username: "thiccyricky", id:"253"},
    {firstName: "Rihrd", username: "thiccyriccy", id:"253"},
  ]


  function renderUsers(users) {
    var tableRows = jQuery("#table-rows")
    for(var i=0; i<users;i++){
      var user = users[i]
      tableRows.append(`
        <tr>
          <td>${user.username}</td>
          <td>&nbsp;</td>
          <td>${user.firstName}</td>
          <td>Lovelace</td>
          <td>${user.id}</td>
          <td>
            <span class="pull-right">
            <i class="fa-2x fa fa-times wbdv-remove"></i>
            <i class="fa-2x fa fa-pencil wbdv-edit"></i>
            </span>
          </td>
        </tr>`);
    }
  }

  function main() {
    renderUsers(users)
  }
$(main)
  function createUser() { … }
  function deleteUser() { … }
  function selectUser() { … }
  function updateUser() { … }
  function findAllUsers() { … } // optional - might not need this
  function findUserById() { … } // optional - might not need this
//})(); */
