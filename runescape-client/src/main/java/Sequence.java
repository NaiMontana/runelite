import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jn")
@Implements("Sequence")
public class Sequence extends CacheableNode {
   @ObfuscatedName("s")
   @Export("skeletons")
   public static NodeCache skeletons;
   @ObfuscatedName("t")
   @Export("sequences")
   public static NodeCache sequences;
   @ObfuscatedName("w")
   @Export("skel_ref")
   static IndexDataBase skel_ref;
   @ObfuscatedName("a")
   @Export("skin_ref")
   static IndexDataBase skin_ref;
   @ObfuscatedName("i")
   @Export("seq_ref")
   static IndexDataBase seq_ref;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -503370479
   )
   @Export("precedenceAnimating")
   public int precedenceAnimating;
   @ObfuscatedName("r")
   @Export("frameIDs")
   public int[] frameIDs;
   @ObfuscatedName("e")
   @Export("interleaveLeave")
   int[] interleaveLeave;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -984122893
   )
   @Export("priority")
   public int priority;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1748668763
   )
   @Export("frameStep")
   public int frameStep;
   @ObfuscatedName("y")
   @Export("frameLenghts")
   public int[] frameLenghts;
   @ObfuscatedName("o")
   @Export("stretches")
   public boolean stretches;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 290861403
   )
   @Export("leftHandItem")
   public int leftHandItem;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1927296735
   )
   @Export("forcedPriority")
   public int forcedPriority;
   @ObfuscatedName("v")
   int[] field3611;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 80544211
   )
   @Export("rightHandItem")
   public int rightHandItem;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 2006630437
   )
   @Export("maxLoops")
   public int maxLoops;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 556657143
   )
   @Export("replyMode")
   public int replyMode;
   @ObfuscatedName("j")
   public int[] field3613;

   static {
      sequences = new NodeCache(64);
      skeletons = new NodeCache(100);
   }

   Sequence() {
      this.frameStep = -1;
      this.stretches = false;
      this.forcedPriority = 5;
      this.leftHandItem = -1;
      this.rightHandItem = -1;
      this.maxLoops = 99;
      this.precedenceAnimating = -1;
      this.priority = -1;
      this.replyMode = 2;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1513745667"
   )
   void method4705(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.readUnsignedShort();
         this.frameLenghts = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.frameLenghts[var4] = var1.readUnsignedShort();
         }

         this.frameIDs = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.frameIDs[var4] = var1.readUnsignedShort();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.frameIDs[var4] += var1.readUnsignedShort() << 16;
         }
      } else if(var2 == 2) {
         this.frameStep = var1.readUnsignedShort();
      } else if(var2 == 3) {
         var3 = var1.readUnsignedByte();
         this.interleaveLeave = new int[var3 + 1];

         for(var4 = 0; var4 < var3; ++var4) {
            this.interleaveLeave[var4] = var1.readUnsignedByte();
         }

         this.interleaveLeave[var3] = 9999999;
      } else if(var2 == 4) {
         this.stretches = true;
      } else if(var2 == 5) {
         this.forcedPriority = var1.readUnsignedByte();
      } else if(var2 == 6) {
         this.leftHandItem = var1.readUnsignedShort();
      } else if(var2 == 7) {
         this.rightHandItem = var1.readUnsignedShort();
      } else if(var2 == 8) {
         this.maxLoops = var1.readUnsignedByte();
      } else if(var2 == 9) {
         this.precedenceAnimating = var1.readUnsignedByte();
      } else if(var2 == 10) {
         this.priority = var1.readUnsignedByte();
      } else if(var2 == 11) {
         this.replyMode = var1.readUnsignedByte();
      } else if(var2 == 12) {
         var3 = var1.readUnsignedByte();
         this.field3611 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3611[var4] = var1.readUnsignedShort();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3611[var4] += var1.readUnsignedShort() << 16;
         }
      } else if(var2 == 13) {
         var3 = var1.readUnsignedByte();
         this.field3613 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3613[var4] = var1.read24BitInt();
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LModel;II)LModel;",
      garbageValue = "-1837943342"
   )
   public Model method4704(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = MouseInput.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var3 == null) {
         return var1.method2530(true);
      } else {
         Model var4 = var1.method2530(!var3.method2872(var2));
         var4.method2497(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LModel;ILSequence;IS)LModel;",
      garbageValue = "-8935"
   )
   public Model method4694(Model var1, int var2, Sequence var3, int var4) {
      var2 = this.frameIDs[var2];
      Frames var5 = MouseInput.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var5 == null) {
         return var3.method4704(var1, var4);
      } else {
         var4 = var3.frameIDs[var4];
         Frames var6 = MouseInput.getFrames(var4 >> 16);
         var4 &= '\uffff';
         Model var7;
         if(var6 == null) {
            var7 = var1.method2530(!var5.method2872(var2));
            var7.method2497(var5, var2);
            return var7;
         } else {
            var7 = var1.method2530(!var5.method2872(var2) & !var6.method2872(var4));
            var7.method2498(var5, var2, var6, var4, this.interleaveLeave);
            return var7;
         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LModel;III)LModel;",
      garbageValue = "2120224999"
   )
   Model method4709(Model var1, int var2, int var3) {
      var2 = this.frameIDs[var2];
      Frames var4 = MouseInput.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var4 == null) {
         return var1.method2530(true);
      } else {
         Model var5 = var1.method2530(!var4.method2872(var2));
         var3 &= 3;
         if(var3 == 1) {
            var5.method2502();
         } else if(var3 == 2) {
            var5.method2495();
         } else if(var3 == 3) {
            var5.method2487();
         }

         var5.method2497(var4, var2);
         if(var3 == 1) {
            var5.method2487();
         } else if(var3 == 2) {
            var5.method2495();
         } else if(var3 == 3) {
            var5.method2502();
         }

         return var5;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(LModel;II)LModel;",
      garbageValue = "2033910612"
   )
   Model method4693(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = MouseInput.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var3 == null) {
         return var1.method2500(true);
      } else {
         Model var4 = var1.method2500(!var3.method2872(var2));
         var4.method2497(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(LModel;IS)LModel;",
      garbageValue = "-6003"
   )
   public Model method4695(Model var1, int var2) {
      int var3 = this.frameIDs[var2];
      Frames var4 = MouseInput.getFrames(var3 >> 16);
      var3 &= '\uffff';
      if(var4 == null) {
         return var1.method2530(true);
      } else {
         Frames var5 = null;
         int var6 = 0;
         if(this.field3611 != null && var2 < this.field3611.length) {
            var6 = this.field3611[var2];
            var5 = MouseInput.getFrames(var6 >> 16);
            var6 &= '\uffff';
         }

         Model var7;
         if(var5 != null && var6 != '\uffff') {
            var7 = var1.method2530(!var4.method2872(var3) & !var5.method2872(var6));
            var7.method2497(var4, var3);
            var7.method2497(var5, var6);
            return var7;
         } else {
            var7 = var1.method2530(!var4.method2872(var3));
            var7.method2497(var4, var3);
            return var7;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1316751504"
   )
   @Export("post")
   void post() {
      if(this.precedenceAnimating == -1) {
         if(this.interleaveLeave != null) {
            this.precedenceAnimating = 2;
         } else {
            this.precedenceAnimating = 0;
         }
      }

      if(this.priority == -1) {
         if(this.interleaveLeave != null) {
            this.priority = 2;
         } else {
            this.priority = 0;
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "16711935"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4705(var1, var2);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1968205019"
   )
   public static int method4728(int var0, int var1) {
      int var2 = var0 >>> 31;
      return (var0 + var2) / var1 - var2;
   }
}
