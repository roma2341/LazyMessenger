package com.softgroup.service.profile.impl.handler;

import com.softgroup.common.database.model.UserContact;
import com.softgroup.common.database.services.UserContactService;
import com.softgroup.common.database.services.UserProfileService;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseStatus;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.services.profile.api.handler.ProfileHandler;
import com.softgroup.services.profile.api.message.request.ContactsSyncRequestData;
import com.softgroup.services.profile.api.message.response.ContactsSyncResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

/**
 * Created by zigza on 28.02.2017.
 */
@Component
public class ContactsSyncRequestHandler extends AbstractRequestHandler<ContactsSyncRequestData,ContactsSyncResponseData> implements ProfileHandler {
    @Autowired
    UserContactService contactService;

    @Override
    public String getName() {
        return "contacts_sync";
    }

    public Response<ContactsSyncResponseData> process(Request<ContactsSyncRequestData> request) {
        ContactsSyncRequestData requestData = request.getData();
        List<UserContact> addedContacts = requestData.getAddedContacts();
        List<UserContact> removedContracts = requestData.getRemovedContacts();

        UserContactService.ContactsCommit contactsCommit = new UserContactService.ContactsCommit();
        contactsCommit.setAddedContacts(addedContacts);
        contactsCommit.setRemovedContacts(removedContracts);
        contactService.syncContacts(contactsCommit);

        ContactsSyncResponseData responseData = new ContactsSyncResponseData();
        Response<ContactsSyncResponseData> response = new Response<ContactsSyncResponseData>();

        response.setHeader(request.getHeader());
        response.setData(responseData);

        ResponseStatus status = new ResponseStatus();
        status.setCode(200);
        status.setMessage("OK");
        response.setStatus(status);

        return response;
    }
}
