<body>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <form action="dept" method="POST">
        <div class="input-group flex-nowrap">
            <div class="input-group-prepend">
                <span class="input-group-text" id="addon-wrapping">@</span>
            </div>
            <input type="text" class="form-control" placeholder="Dep id:" name="depNumber"
                   aria-describedby="addon-wrapping">
            <br/>
            <input type="text" class="form-control" placeholder="nameDept:" name="nameDept"
                   aria-describedby="addon-wrapping">
            <br/>
        </div>
        <input class="btn btn-primary" type="submit" value="Submit">
    </form>
