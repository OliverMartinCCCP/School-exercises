function partim2listItem(p) {
    return "<li code='" + p.code + "'>" + p.name + "<img class='sp' src='sp.svg?max=6&sp=" + p.sp + "'/></li>";
}

function processGetPartimsAttempt(data) {
    $("#partimList").text("");
    if (data.partims) {
        data.partims.map(partim2listItem)
            .forEach(pli => $("#partimList").append(pli));
    } else {
        setMsg($("#partims .error"), "received wrong data:" + data);
    }
}

function performGetPartimsAttempt() {
    $.ajax({
        url: "GETPARTIMS",
        method: "GET",
        error: console.log
    }).done(processGetPartimsAttempt);
}

function performUpdatePartimAttempt(cbChangedEvent) {
    var state = cbChangedEvent.target.checked;
    var partimCode = cbChangedEvent.target.value;
    $.ajax({
        url: "UPDATEPARTIM",
        data: "keep=" + state + "&code=" + partimCode,
        error: console.log
    }).done(processUpdatePartimAttempt);
}

function processUpdatePartimAttempt(data) {
    if (data.error) {
        setMsg($("#partims .error"), data.error);
    } else if (data.msg) {
        setMsg($("#partims .msg"), data.msg);
    } else {
        console.log("processUpdatePartimAttempt: Ukn response : " + data);
    }
    
}

function addCheckboxToPartim($li, partimCode, checked) {
    if ($li.find("input").length === 0) {
        var cb = $('<input />', {type: 'checkbox', checked: checked, value: partimCode});
        cb.on('change', performUpdatePartimAttempt);
        $li.prepend(cb);
    } else {
        console.log("cb aleady exists ...: ");
    }
}

function updatePartims(partims) {
    $("#partimList li").each(function (idx) {
        var liCode = $(this).attr("code");
        var hasPartim = partims.find(x => (x.code === liCode));
        addCheckboxToPartim($(this), liCode, hasPartim);
    });
}

var submitter = null;
$("#login").find('input[type=submit]').click(function (evt) {
    submitter = this;
});

function getLoginFormData() {
    return $('#login').serialize() + "&action=" + submitter.name;
}

function performLoginAttempt(sumbitButtonClickEvent) {
    var data = {action: "check"};
    if (sumbitButtonClickEvent) {
        sumbitButtonClickEvent.preventDefault();
        data = getLoginFormData();
    }
    $.ajax({
        url: "LOGIN",
        data: data,
        error: console.log
    }).done(processLoginAttempt);
}

function setMsg($el, msg) {
    $el.removeClass("invis");
    $el.text( msg );
}

function processLoginAttempt(data) {
    if (data.error) {
        setMsg($("#login .error"), data.error);
    } else if (data.partims) {
        $("#login div.content").text("");
        $("#login div.content").append(
                "<div class='info'>" +
                data.msg +
                "</div>"
                );

        var $logoutBtn = $('<input />', {type: 'submit',
            class: "submit",
            name: "logout",
            value: "Logout"});
        $logoutBtn.on('click', performLogoutAttempt);

        $("#login div.content").append($logoutBtn);

        updatePartims(data.partims);
    } else if (data.msg) {
        if (data.msg === "checked: not logged in") {/**/}
        else  setMsg($("#login .error"), "received wrong data:" + data.msg);
    } else {
        setMsg($("#login .error"), "received wrong data:" + data);
    }
}

function performLogoutAttempt(btnClickEvt) {
    $.ajax({
        url: "LOGOUT",
        error: console.log
    }).done(processLogoutAttempt);
}

function processLogoutAttempt() {
    location.reload();
}

$(function () {
    console.log("Loaded ...");
    $("#login").on('submit', performLoginAttempt);
    performGetPartimsAttempt();
    performLoginAttempt();
});