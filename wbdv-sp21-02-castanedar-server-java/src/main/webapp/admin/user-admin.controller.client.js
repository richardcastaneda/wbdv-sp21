//Create necessary variables
var $createButton;
var $tableRows;
var $username;
var $password;
var $firstName;
var $lastName;
var $role;
var selectedUser = null
var userService = new AdminUserServiceClient()

// deleteUser function deletes a user
function deleteUser(event){
    var button = $(event.target)
    var index = button.attr("id")
    console.log(index)
    var id = users[index]._id
    userService.deleteUser(id)
      .then(function(status) {
        users.splice(index, 1)
        renderUsers(users)
      })
}

function createUser(){
    var newUser = {
      username: $username.val(),
      password: $password.val(),
      firstName: $firstName.val(),
      lastName: $lastName.val(),
      role: $role.val()
    }
    userService.createUser(newUser)
      .then(function(actualUser){
        users.push(actualUser)
        renderUsers(users)
      })
}

function updateUser(event){
  var id = $(event.target).attr("id")
  selectedUser = users.find(user => user._id === id)
  console.log(event)
  $username.val(selectedUser.username)
  $password.val(selectedUser.password)
  $firstName.val(selectedUser.firstName)
  $lastName.val(selectedUser.lastName)
  $role.val(selectedUser.role)
}

function renderUsers(users) {
  $tableRows.empty()
  for(var i=0; i<users.length; i++) {
    var user = users[i]
    $tableRows
    .prepend(`
      <tr>
          <td>${user.username}</td>
          <td>&nbsp;</td>
          <td>${user.firstName}</td>
          <td>${user.lastName}</td>
          <td>${user.Role}</td>
          <td>
            <span class="pull-right">
            <button id="${i}" class="fa-2x fa fa-times wbdv-remove"></button>
            <button id="${user._id}" class="fa-2x fa fa-pencil wbdv-edit"></button>
            </span>
          </td>
        </tr>`);
  }
  $(".wbdv-remove").click(deleteUser)
  $(".wbdv-edit").click(updateUser)
}

function main(){
  $tableRows = $("#table-rows")
  $createButton = $(".wbdv-create")
  $username = $("#usernameFld")
  $password = $("#passwordFld")
  $firstName = $("#firstNameFld")
  $lastName = $("#lastNameFld")
  $role = $("#roleFld")
  $createButton.click(createUser)
  users = userService.findAllUsers().then(function(actualUsers){
    users = actualUsers
    renderUsers(users)
  })
}
$(main)