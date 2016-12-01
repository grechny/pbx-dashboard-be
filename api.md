# API for PBX Dashboard

<table>
  <tr>
      <th>URI</th>
      <th>Description</th>
      <th>Method</th>
      <th>Request</th>
      <th>Response</th>
  </tr>

  <tr>
    <td><pre>/api/userProfileDto/login</pre></td>
    <td>Login userProfileDto</td>
    <td>POST</td>
    <td>
      <pre lang="js">
{
  "username": "string",
  "password": "string"
}
      </pre>
    </td>
    <td></td>
  </tr>
  
  <tr>
    <td><pre>/api/userProfileDto/logout</pre></td>
    <td>Logout userProfileDto</td>
    <td>POST</td>
    <td></td>
    <td></td>
  </tr>
  
  <tr>
    <td><pre>/api/userProfileDto/profile</pre></td>
    <td>Get authenticated userProfileDto information</td>
    <td>GET</td>
    <td></td>
    <td>
      <pre lang="js">
{
  "username": "string",
  "companyName": "string"
}
      </pre>
    </td>
  </tr>
  
  <tr>
    <td><pre>/api/calltracking/prefixes</pre></td>
    <td>Get prefix list for calltracking</td>
    <td>GET</td>
    <td></td>
    <td>
      <pre lang="js">
{
  "description": "string",
  "prefix": "string",
  "destination": "string",
  "destinationType": "destinationType",
  "options": []
}
      </pre>
    </td>
  </tr>
  
  <tr>
    <td><pre>/api/dashboard/layout</pre></td>
    <td>Get dashboard widgets positions and sizes</td>
    <td>GET</td>
    <td></td>
    <td>
      <pre lang="js">
{
  "layout": "string"
}
      </pre>
    </td>
  </tr>

  <tr>
    <td><pre>/api/dashboard/layout</pre></td>
    <td>Create dashboard widgets positions and sizes</td>
    <td>POST</td>
    <td>
      <pre lang="js">
{
  "layout": "string"
}
      </pre>
    </td>
    <td></td>
  </tr>

  <tr>
    <td><pre>/api/dashboard/layout</pre></td>
    <td>Update dashboard widgets positions and sizes</td>
    <td>PUT</td>
    <td>
      <pre lang="js">
{
  "layout": "string",
}
      </pre>
    </td>
    <td></td>
  </tr>
  
</table>
