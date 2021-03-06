package net.minecraft.server;

import java.util.List;
import java.util.Random;

public abstract class BlockStepAbstract extends Block {

    private final boolean a;

    public BlockStepAbstract(int i, boolean flag, Material material) {
        super(i, 6, material);
        this.a = flag;
        if (flag) {
            q[i] = true;
        } else {
            this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
        }

        this.h(255);
    }

    public void updateShape(IBlockAccess iblockaccess, int i, int j, int k) {
        if (this.a) {
            this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        } else {
            boolean flag = (iblockaccess.getData(i, j, k) & 8) != 0;

            if (flag) {
                this.a(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
            } else {
                this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
            }
        }
    }

    public void f() {
        if (this.a) {
            this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        } else {
            this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
        }
    }

    public void a(World world, int i, int j, int k, AxisAlignedBB axisalignedbb, List list, Entity entity) {
        this.updateShape(world, i, j, k);
        super.a(world, i, j, k, axisalignedbb, list, entity);
    }

    public int a(int i) {
        return this.a(i, 0);
    }

    public boolean c() {
        return this.a;
    }

    public int getPlacedData(World world, int i, int j, int k, int l, float f, float f1, float f2, int i1) {
        return this.a ? 0 : (l != 0 && (l == 1 || (double) f1 <= 0.5D) ? i1 : i1 | 8);
    }

    public int a(Random random) {
        return this.a ? 2 : 1;
    }

    public int getDropData(int i) {
        return i & 7;
    }

    public boolean b() {
        return this.a;
    }

    public abstract String d(int i);
}
