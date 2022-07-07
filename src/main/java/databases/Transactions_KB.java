package databases;

/**
 * // TODO add some description
 *
 * @author Artem Boiko
 */
public class Transactions_KB {
    public static void main(String[] args) {
        /**
         * optimistic locking
         *
         *         try {
         *             updatedFaculty = facultyRepository.save(faculty);
         *         } catch (ObjectOptimisticLockingFailureException e) {
         *             throw new RepositoryException("Data has changed. Please refresh the page and try again.");
         *         }
         *
         *         создать в entity классе поле с геттерами/сеттерами (javax.persistence):
         *         @Version
         *         private Integer version;
         *
         *         в этом же классе добавить к классу аннотацию:
         *         @OptimisticLocking(type = OptimisticLockType.VERSION)
         *
         *         добавить changeSet:
         *     <changeSet author="Artem Boiko" id="002-add-version-column-to-faculties-table">
         *         <addColumn tableName="faculties">
         *             <column name="version"
         *                     type="int"/>
         *         </addColumn>
         *     </changeSet>
         *
         *         обязательно в форме на UI передавать как скрытый параметр наше поле version:
         *         <input type="hidden" id="version" th:field="*{version}">
         *
         *
         */


    }
}
