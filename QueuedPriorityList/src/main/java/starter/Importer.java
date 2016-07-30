package starter;

import java.util.Map;
import java.util.Set;
import java.util.Stack;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

public class Importer {

    public void execute() {
        Set<Entity> entities = prepareData();
        importElements(entities);
    }

    private void importElements(Set<Entity> entities) {
        // initially all elements with at least one parent
        Stack<Entity> rootEntities = new Stack<Entity>();
        // initially all elements without parent
        Map<String, WrappedEntity> backlogEntities = Maps.newHashMap();

        // initialize rootList and backlogList
        for (Entity entity : entities) {
            if (entity.getParents() == null || entity.getParents().size() == 0) {
                rootEntities.push(entity);
            } else {
                WrappedEntity we = new WrappedEntity();
                we.setEntity(entity);
                we.setNumberOfUnsavedParents(entity.getParents().size());
                backlogEntities.put(entity.getId(), we);
            }
        }

        // worker
        while (!rootEntities.empty()) {
            Entity entity = rootEntities.pop();
            doWorkOnParent(entity);
            if (entity.getChildren() != null) {
                for (Entity child : entity.getChildren()) {
                    WrappedEntity we = backlogEntities.get(child.getId());
                    we.decrease();
                    if (we.getNumberOfUnsavedParents() == 0) {
                        rootEntities.push(we.getEntity());
                        backlogEntities.remove(we.getEntity().getId());
                    }
                }
            }
        }
    }

    private void doWorkOnParent(Entity entity) {
        System.out.println(entity.getId());
    }

    private Set<Entity> prepareData() {
        // create entities
        Entity rootLeaf1 = new Entity("rootLeaf1");
        Entity rootLeaf2 = new Entity("rootLeaf2");
        Entity p1 = new Entity("P1");
        Entity p2 = new Entity("P2");
        Entity p3 = new Entity("P3");
        Entity p4 = new Entity("P4");
        Entity rootParent1 = new Entity("rootParent1");
        Entity rootParent2 = new Entity("rootParent2");
        Entity l1ChildA = new Entity("L1ChildA");
        Entity l1ChildB = new Entity("L1ChildB");
        Entity grandHeir = new Entity("GrandHeir");

        // connect entities
        p4.addParent(p3.addParent(p2.addParent(p1)));
        grandHeir.addParent(p4).addParent(l1ChildA);
        l1ChildA.addParent(rootParent2).addParent(rootParent1);
        p3.addParent(l1ChildB);
        l1ChildB.addParent(rootParent2).addParent(p2);

        // add entities
        Set<Entity> result = Sets.newHashSet(rootLeaf1, p1, p4, rootParent2, p3, rootLeaf2, p2, rootParent1, grandHeir, l1ChildA, l1ChildB);

        return result;
    }

}

@Getter
@Setter
@RequiredArgsConstructor
class Entity {
    private final String id;
    private Set<Entity> parents = Sets.newHashSet();
    private Set<Entity> children = Sets.newHashSet();

    public Entity addParent(Entity parent) {
        parents.add(parent);
        parent.children.add(this);
        return this;
    }
}

@Getter
@Setter
class WrappedEntity {
    public void decrease() {
        if (numberOfUnsavedParents == 0) {
            throw new RuntimeException("Cannot decrease, number of elements is already 0.");
        }
        numberOfUnsavedParents--;
    }

    private int numberOfUnsavedParents = 0;
    private Entity entity;
}