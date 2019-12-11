import React from 'react'
import {BootstrapTable, TableHeaderColumn} from 'react-bootstrap-table';
import axios from "axios";


class TeachersTable extends React.Component {
    handleDeletedRow(rowKeys) {
        console.log(rowKeys[0]);
        return axios
            .get('/teachers/delete?id='+rowKeys[0], {"Access-Control-Allow-Headers": "Origin, X-Requested-With, Content-Type, Accept"})
            .then(response => {
                console.log(response)
            })
            .catch(error => {
                console.log(error);
            })
    }

    handleInsertedRow(row) {
        console.log(`${row.subjectId}&${row.subjectStartyear}&${row.schoolkidYearofstudy}`)
        return axios
            .get(`/teachers/create?teacherId=${row.teacherId}&teacherFullname=${row.teacherFullname}&teacherInfo=${row.teacherInfo}`,{"Access-Control-Allow-Headers": "Origin, X-Requested-With, Content-Type, Accept"})
            .then(response => {
                console.log(response)
            })
            .catch(error => {
                console.log(error);
            });
    }

    customConfirm(next, dropRowKeys){
        const dropRowKeysStr = dropRowKeys.join(',');
        if (window.confirm(`Вы уверены, что хотите удалить ${dropRowKeysStr}?`)) {
            next();
        }
    }

    beforeSaveCell(row, cellName, cellValue) {
        row[cellName] = cellValue;
        return axios
            .get(`/teachers/update?teacherId=${row.teacherId}&teacherFullname=${row.teacherFullname}&teacherInfo=${row.teacherInfo}`,{"Access-Control-Allow-Headers": "Origin, X-Requested-With, Content-Type, Accept"})
            .then(response => {
                console.log(response)
            })
            .catch(error => {
                console.log(error);
            });
    }

    render() {
        const options = {
            afterDeleteRow: this.handleDeletedRow,
            afterInsertRow: this.handleInsertedRow,
            handleConfirmDeleteRow: this.customConfirm,
            insertText: 'Добавить преподавателя',
            deleteText: 'Уволить преподавателя',
            saveText: 'Сохранить'
        };

        const selectRow = {
            mode: 'radio',
            clickToSelect: true,
            clickToSelectAndEditCell: true,
            unselectable: [ 'row1' ]
        };

        const cellEdit = {
            mode: 'dbclick', // click cell to edit
            beforeSaveCell: this.beforeSaveCell,
            blurToSave: true
        };
        return (
            <div>
                <BootstrapTable hoverselectRow={ selectRow } cellEdit={ cellEdit } data={this.props.data} deleteRow options={ options } insertRow>
                    <TableHeaderColumn hidden

                                       selectRow={ selectRow }
                                       deleteRow isKey dataField='teacherId'>
                        ID
                    </TableHeaderColumn>
                    <TableHeaderColumn deleteRow dataField='teacherFullname'>
                        Имя преподавателя
                    </TableHeaderColumn>
                    <TableHeaderColumn deleteRow dataField='teacherInfo'>
                        Информация
                    </TableHeaderColumn>
                </BootstrapTable>
            </div>
        )
    }
}

export default TeachersTable;