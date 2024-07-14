function onSubmitForm() {
    Swal.fire({
        icon: 'success',
        title: 'Success!',
        text: 'Student information has been updated.',
        showConfirmButton: false,
        timer: 1500
    });

    return true; // Return true to submit the form
}