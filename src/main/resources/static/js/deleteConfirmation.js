function confirmDelete(event) {
    var studentId = event.target.getAttribute('data-student-id');

    Swal.fire({
        title: 'Are you sure?',
        text: 'You will not be able to recover this student record!',
        icon: 'warning',
        showCancelButton: true,
        confirmButtonText: 'Yes, delete it!',
        cancelButtonText: 'No, cancel',
        reverseButtons: true
    }).then((result) => {
        if (result.isConfirmed) {
            window.location.href = '/students/delete/' + studentId;
        } else if (result.dismiss === Swal.DismissReason.cancel) {
            Swal.fire('Cancelled', 'Your student record is safe :)', 'info');
        }
    });

    event.preventDefault();
}
